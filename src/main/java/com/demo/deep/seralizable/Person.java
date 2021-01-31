package com.demo.deep.seralizable;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.*;

/**
 * @author Liutx
 * @date 2021/1/31 16:06
 * @Description
 */

@Data
@AllArgsConstructor
public class Person implements Serializable {
    private static final long serialVersionUID = 369285298572941L;

    private String name;
    private int age;
    private String email;
    private PersonDesc personDesc;


    public Person(String name, int age, String email, String desc) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.personDesc = new PersonDesc();
        this.personDesc.setDesc(desc);
    }

    @Override
    public Person clone() {
        Person person = null;
        try {
            // 将该对象序列化成流,因为写在流里的是对象的一个拷贝，而原对象仍然存在于JVM里面。所以利用这个特性可以实现对象的深拷贝
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this);
            // 将流序列化成对象
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            person = (Person) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return person;
    }

    public void setDesc(String desc) {
        this.personDesc.setDesc(desc);
    }


    public static class PersonApp {
        public static void main(String[] args) throws Exception {
            // 初始化一个对象
            Person person = new Person("平头", 20, "123456@qq.com", "技术");
            // 复制对象
            Person person1 = (Person) person.clone();
            // 改变 person1 的属性值
            person1.setName("我是平头的克隆对象");
            // 修改 person age 的值
            person1.setAge(22);
            person1.setDesc("我已经关注了技术");
            System.out.println("person对象：" + person);
            System.out.println();
            System.out.println("person1对象：" + person1);
        }
    }
}
