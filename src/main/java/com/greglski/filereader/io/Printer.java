package com.greglski.filereader.io;

public class Printer {
    FileFilterProcessor fileFilterProcessor;

    public Printer(FileFilterProcessor fileFilterProcessor) {
        this.fileFilterProcessor = fileFilterProcessor;
    }

    public void showNumberOfUsers() {
        System.out.println("Total number of users: " + fileFilterProcessor.countNumberOfUsers());
    }

    public void showEldestUserWithPhone() {
        for (Person personUser: fileFilterProcessor.filter()) {
            System.out.println("The eldest user with phone number is: " +
                    personUser.getFirstname() + " " +
                    personUser.getLastname() +
                    ", age: " + " " + personUser.getAge() +
                    ", phone number: " + personUser.getPhoneNumber());
        }
    }
}
