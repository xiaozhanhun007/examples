package com.zzp.structure.adapter;

/**
 * @Description 狗的对象适配器
 * @author Garyzeng
 * @since 2019.11.25
 **/
public class DogObjectAdapter implements Dog{

    private Cat cat;

    public DogObjectAdapter(Cat cat) {
        this.cat = cat;
    }

    public void bark() {
        cat.meow();
    }

    public void run() {
        cat.run();
    }
}
