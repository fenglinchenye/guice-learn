package com.freedo;

import com.freedo.helloworddemo.CommandLineModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;

import java.util.Map;

public class App {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        // 针对需要外部传参的，切勿直接传递一层到一层的传有参到实现，可以使用一个Module(args)。
        // 然后在需要的地方使用依赖
        Injector injector = Guice.createInjector(
                new MainModule(),
                new CommandLineModule(args));

        MyApplet myApplet = Applets.get(injector, args[0]);
        myApplet.run();
    }
}
