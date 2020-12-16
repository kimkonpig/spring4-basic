package chap02.main;

import chap02.AuthenticationService;
import chap02.PasswordChangeService;
import chap02.conf.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainByJavaConfig {

    public static void main(String[] args){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);

        AuthenticationService authSvc = ctx.getBean("authenticationService", AuthenticationService.class);
        authSvc.authenticate("kimkonpig", "qwer");

        PasswordChangeService pwChgSvc = ctx.getBean(PasswordChangeService.class);
        pwChgSvc.changePassword("kimkonpig", "qwer", "asdf");

        authSvc.authenticate("kimkonpig", "qwer");

        ctx.close();
    }
}
