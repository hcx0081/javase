package com.javase.view;

import java.util.Scanner;

/**
 * @Description:
 */
public class QqView {
    private boolean loop = true;
    
    public static void main(String[] args) {
        new QqView().mainMenu();
    }
    
    private void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("====欢迎====");
            System.out.println("1 登录");
            System.out.println("2 退出");
            System.out.println("请输入你的选择：");
            int command = scanner.nextInt();
            switch (command) {
                case 1:
                    System.out.print("请输入用户名：");
                    String userId = scanner.next();
                    System.out.print("请输入密码：");
                    String password = scanner.next();
                    
                    if (true) {
                        System.out.println("====欢迎" + userId + "登录====");
                        while (loop) {
                            System.out.println("1 显示在线用户列表");
                            System.out.println("2 群发消息");
                            System.out.println("3 私聊消息");
                            System.out.println("4 发送文件");
                            System.out.println("5 退出");
                            System.out.println("请输入你的选择：");
                            command = scanner.nextInt();
                            switch (command) {
                                case 1:
                                    System.out.println("显示在线用户列表");
                                    break;
                                case 2:
                                    System.out.println("群发消息");
                                    break;
                                case 3:
                                    System.out.println("私聊消息");
                                    break;
                                case 4:
                                    System.out.println("发送文件");
                                    break;
                                case 5:
                                    loop = false;
                                    System.out.println("退出");
                                    break;
                            }
                        }
                        
                    } else {
                        System.out.println("登录失败");
                        break;
                    }
                    
                    
                    break;
                
                case 2:
                    System.exit(0);
                    System.out.println("退出系统");
                    break;
            }
        }
    }
}
