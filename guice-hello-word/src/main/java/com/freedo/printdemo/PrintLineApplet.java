package com.freedo.printdemo;

import com.freedo.MyApplet;
import com.freedo.helloworddemo.Args;
import com.freedo.helloworddemo.CommandLineModule;

import javax.inject.Inject;
import java.util.List;

public class PrintLineApplet implements MyApplet {

    private List<String> args;

    @Inject
    public PrintLineApplet(@Args List<String> args) {
        this.args = args;
    }

    @Override
    public void run() {
        System.out.println("print line====");
        System.out.println(args.get(1));
    }

}
