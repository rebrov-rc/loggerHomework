package com.logger.app;

/**
 * Logger
 */
class Logger {

    private static int logCounter = 0;
    private static Logger instance = null;;

    private Logger(){}

    private static String building(String msg){

        DateBuilder date = new DateBuilder();
        StringBuilder builder = new StringBuilder("[");

        builder.append(date.getDate());
        builder.append(" ");
        builder.append(date.getTime());
        builder.append(" ");
        builder.append(++logCounter);
        builder.append("] ");
        builder.append(msg);

        return builder.toString();
    }


    public  static void log(String msg){
        System.out.println(building(msg));
    }

    public static Logger getInstance(){
        return instance == null? (instance = new Logger()) : instance;
    }
}