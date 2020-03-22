package com.freedo;

import com.freedo.MyApplet;
import com.google.common.base.Joiner;
import com.google.inject.Binder;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import com.google.inject.binder.LinkedBindingBuilder;
import com.google.inject.multibindings.MapBinder;

import java.util.Map;

public class Applets {

    public static class AppletRegister{
        private final Binder binder;

        public AppletRegister(Binder binder) {
            this.binder = binder;
        }

        public LinkedBindingBuilder<MyApplet> named(String name) {
            return MapBinder.newMapBinder(binder, String.class, MyApplet.class).addBinding(name);
        }
    }

    public static AppletRegister register(Binder binder) {
        return new AppletRegister(binder);
    }

    public static MyApplet get(Injector injector, String name) {
        Map<String, MyApplet> myAppletMap = injector.getInstance(Key.get(new TypeLiteral<Map<String, MyApplet>>() {
        }));
        if (!myAppletMap.containsKey(name)){
            throw new IllegalArgumentException("name: "+name+" not exist, valid applets are "+ Joiner.on(", ").join(myAppletMap.keySet()));
        }
        return myAppletMap.get(name);
    }
}
