package me.xdd.self.criminalintent.sqlite;

/**
 * 用于描述表名和数据字段
 * @author xuandong on 2019/4/18.
 */
public class CrimeDbSchema {

    //描述数据表
    public static final class CrimeTable{
        //数据库表名
        public static final String NAME = "crimes";

        //定义数据表字段
        public static final class Cols{
            public static final String UUID = "uuid";
            public static final String TITLE = "title";
            public static final String DATE = "date";
            public static final String SOLVED = "solved";
            public static final String SUSPECT = "suspect";  //嫌疑人
        }
    }
}
