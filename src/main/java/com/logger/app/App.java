package com.logger.app;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;


/**
 * App
 */
public class App {

    private Scanner scn = new Scanner(System.in);
    private int mode = 1;
    private List<Integer> list;
    private int N = 0;
    private int M = 0;

    private int parser(String str){
        try{
            int res = Integer.parseInt(str);
            return res;
        }catch(NumberFormatException ex){
            return -1;
        }
    }

    public void run(){

        Logger logger = Logger.getInstance();

        logger.log("Запускаем программу");

        while (true) {

            String req = null;

            if (this.mode == 1) {
                logger.log("Просим пользователя ввести входные данные для списка");
                System.out.print("Введите размер списка: ");
                req = scn.nextLine();
                int num = this.parser(req);
                if(num > 0){
                    this.N = num;
                    this.mode = 2;
                }else{
                    System.out.println("Некорректное значение.");
                }
            }
            if (this.mode == 2) {

                System.out.print("Введите верхнюю границу для значений: ");
                req = scn.nextLine();
                int num = this.parser(req);
                if(num > 0){
                    this.M = num;
                    this.mode = 3;
                }else{
                    System.out.println("Некорректное значение.");
                }
            }
            if (this.mode == 3) {

                logger.log("Создаём и наполняем список");
                this.list = new ArrayList(N);
                Random random = new Random();

                for(int i = 0; i < this.N; i++){
                    this.list.add(random.nextInt(this.M));
                }

                System.out.println("Вот случайный список: " + this.list.toString());
                this.mode = 4;

            }
            int f = 0;
            if (this.mode == 4) {

                logger.log("Просим пользователя ввести входные данные для фильтрации");
                System.out.print("Введите порог для фильтра: ");
                req = scn.nextLine();

                int num = this.parser(req);
                if(num > 0){
                    f = num;
                    this.mode = 5;
                }else{
                    System.out.println("Некорректное значение.");
                }
            }
            if (this.mode == 5) {
                logger.log("Запускаем фильтрацию");
                var filter = new Filter(f);
                this.list = filter.filterOut(this.list);

                logger.log("Прошло фильтр " + filter.getCount() +" элемента из " + this.N);
                this.mode = 6;
            }
            if (this.mode == 6) {
                logger.log("Выводим результат на экран");
                System.out.println("Отфильтрованный список: " + this.list.toString());
                break;
            }
        }
        logger.log("Завершаем программу");
    }

}