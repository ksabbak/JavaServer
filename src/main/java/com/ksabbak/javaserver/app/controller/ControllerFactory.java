package com.ksabbak.javaserver.app.controller;

import com.ksabbak.javaserver.app.Routes;

public class ControllerFactory {
    public static Controller getController(String path){
        Object[] methods = Routes.methodsForPath(path);
        switch(path) {
            case "/coffee":
                return new CoffeeController(methods);
            default:
                return new Controller(methods);
        }
    }
}

//public String getTypeOfDayWithSwitchStatement(String dayOfWeekArg) {
//     String typeOfDay;
//     switch (dayOfWeekArg) {
//         case "Monday":
//             typeOfDay = "Start of work week";
//             break;
//         case "Tuesday":
//         case "Wednesday":
//         case "Thursday":
//             typeOfDay = "Midweek";
//             break;
//         case "Friday":
//             typeOfDay = "End of work week";
//             break;
//         case "Saturday":
//         case "Sunday":
//             typeOfDay = "Weekend";
//             break;
//         default:
//             throw new IllegalArgumentException("Invalid day of the week: " + dayOfWeekArg);
//     }
//     return typeOfDay;
//}