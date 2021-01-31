package com.demo.deep.cloneable;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Liutx
 * @date 2021/1/31 11:23
 * @Description
 */

@Data
@AllArgsConstructor
public class Person implements Cloneable {
    /**
     * 基本类型属性
     */
    private String name;
    private int age;
    private String email;
    private PersonDesc personDesc;

    public void setDesc(String desc) {
        this.personDesc.setDesc(desc);
    }

    public Person(String name, int age, String email, String desc) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.personDesc = new PersonDesc();
        this.personDesc.setDesc(desc);
    }

    /**
     * 深克隆的方式
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        Person person = (Person) super.clone();
        //对引用对象进行克隆
        person.personDesc = (PersonDesc) personDesc.clone();
        return person;
    }

    /**
     * 引用类型属性
     *
     * @return
     * @throws CloneNotSupportedException
     */

    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person("张三", 20, "123456@qq.com", "Java开发");
        Person person1 = (Person) person.clone();
        person1.setName("Clone 张三S");
        person1.setAge(23);
        person1.setDesc("JavaScript");
        System.out.println(person + " " + person.hashCode());
        System.out.println(person1 + " " + person1.hashCode());
        System.out.println(person == person1);
    }
}
 