package com.zzp.structure.adapter;

/**
 * @Description 狗的类适配器
 * @author Garyzeng
 * @since 2019.11.25
 **/
public class DogClassAdapter extends PersianCat implements Dog{

    public void bark() {
        System.out.println("狗汪汪汪");
    }
}
