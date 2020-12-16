package chap01;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        MavenBuildRunner buildRunner = new MavenBuildRunner();
        buildRunner.setMavenPath("c:\\Program Files\\apache-maven-3.6.3");

        Project sampleProject = new Project();
        List<String> srcDirs = new ArrayList<String>();
        srcDirs.add("src");
        srcDirs.add("srcResources");
        sampleProject.setSrcDirs(srcDirs);
        sampleProject.setBinDir("bin");
        sampleProject.setBuildRunner(buildRunner);

        sampleProject.build();
    }
}
