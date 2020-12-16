package chap02.main;

import chap02.AuthException;
import chap02.AuthenticationService;
import chap02.PasswordChangeService;
import chap02.UserNotFoundException;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainByXml {

    public static void main(String[] args){
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:chap02/config.xml");
        AuthenticationService authSvc = ctx.getBean("authenticationService", AuthenticationService.class);
        runAuthAndCatchAuthEx(authSvc, "kimkonpig", "qwe1");
        runAuthAndCatchAuthEx(authSvc, "kimkonpig", "qwe2");
        runAuthAndCatchAuthEx(authSvc, "kimkonpig", "qwe3");

        try{
            authSvc.authenticate("kimkonpig2", "qwer");
        }catch(UserNotFoundException ex){

        }

        authSvc.authenticate("kimkonpig", "qwer");

        PasswordChangeService pwChgSvc = ctx.getBean(PasswordChangeService.class);
        pwChgSvc.changePassword("kimkonpig", "qwer", "asdf");
        runAuthAndCatchAuthEx(authSvc, "kimkonpig", "qwer");
        authSvc.authenticate("kimkonpig", "asdf");
        ctx.close();
    }

    private static void runAuthAndCatchAuthEx(AuthenticationService authSvc, String userId, String password){
        try{
            authSvc.authenticate(userId, password);
        }catch(AuthException ex){

        }
    }
}
