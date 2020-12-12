package com.holub.database;

import com.holub.text.ParseFailure;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
    static Database database;
    static StringBuilder testString;
    @BeforeAll
    static void setDatabase() throws IOException, ParseFailure {
        database = new Database("");
        database.createTable("student", Arrays.asList("name", "score", "id"));
        String[] names = new String[]{"Shin", "Seok", "Gyeong", "Shin", "Yedarm", "Yun", "Shin", "Yedarm"};
        String[] scores = new String[]{"4.5", "3.8", "4.2", "4.5", "4.5", "2.4", "4.5", "3.8"};
        String[] ids = new String[]{"20182931", "20162345", "20155524", "20182931", "20192313", "20204141", "20141414", "20191111"};
        for(int i = 0; i<names.length;i++){
            database.execute(String.format("INSERT INTO student VALUES(\"%s\", \"%s\", \"%s\")", names[i], scores[i], ids[i]));
        }
    }
    @BeforeEach
    void setTestSring(){
        testString = new StringBuilder();
    }
    @Test
    void executeDistinct() throws IOException, ParseFailure {
        String query = new String("select distinct * from student");
        testString.append("<anonymous>\n");
        testString.append("name\tscore\tid\t");
        testString.append("\n----------------------------------------\n");
        testString.append("Shin\t4.5\t20182931\t\n");
        testString.append("Seok\t3.8\t20162345\t\n");
        testString.append("Gyeong\t4.2\t20155524\t\n");
        testString.append("Yedarm\t4.5\t20192313\t\n");
        testString.append("Yun\t2.4\t20204141\t\n");
        testString.append("Shin\t4.5\t20141414\t\n");
        testString.append("Yedarm\t3.8\t20191111\t\n");
        assertEquals(testString.toString(), database.execute(query).toString());

        query = new String("select distinct score from student");
        testString.delete(0, testString.length());
        testString.append("<anonymous>\n");
        testString.append("score\t");
        testString.append("\n----------------------------------------\n");
        testString.append("4.5\t\n");
        testString.append("3.8\t\n");
        testString.append("4.2\t\n");
        testString.append("2.4\t\n");
        assertEquals(testString.toString(), database.execute(query).toString());

        query = new String("select distinct name, score from student");
        testString.delete(0, testString.length());
        testString.append("<anonymous>\n");
        testString.append("name\tscore\t");
        testString.append("\n----------------------------------------\n");
        testString.append("Shin\t4.5\t\n");
        testString.append("Seok\t3.8\t\n");
        testString.append("Gyeong\t4.2\t\n");
        testString.append("Yedarm\t4.5\t\n");
        testString.append("Yun\t2.4\t\n");
        testString.append("Yedarm\t3.8\t\n");
        assertEquals(testString.toString(), database.execute(query).toString());

        query = new String("select distinct score from student where student.score > 4.0");
        testString.delete(0, testString.length());
        testString.append("<anonymous>\n");
        testString.append("score\t");
        testString.append("\n----------------------------------------\n");
        testString.append("4.5\t\n");
        testString.append("4.2\t\n");
        assertEquals(testString.toString(), database.execute(query).toString());
    }
    @Test
    void executeOrderby1() throws IOException, ParseFailure {
        String query = new String("select * from student order by name");
        testString.append("<anonymous>\n");
        testString.append("name\tscore\tid\t");
        testString.append("\n----------------------------------------\n");
        testString.append("Gyeong\t4.2\t20155524\t\n");
        testString.append("Seok\t3.8\t20162345\t\n");
        testString.append("Shin\t4.5\t20182931\t\n");
        testString.append("Shin\t4.5\t20182931\t\n");
        testString.append("Shin\t4.5\t20141414\t\n");
        testString.append("Yedarm\t4.5\t20192313\t\n");
        testString.append("Yedarm\t3.8\t20191111\t\n");
        testString.append("Yun\t2.4\t20204141\t\n");
        assertEquals(testString.toString(), database.execute(query).toString());

        query= new String("select * from student order by name asc");
        testString.delete(0, testString.length());
        testString.append("<anonymous>\n");
        testString.append("name\tscore\tid\t");
        testString.append("\n----------------------------------------\n");
        testString.append("Gyeong\t4.2\t20155524\t\n");
        testString.append("Seok\t3.8\t20162345\t\n");
        testString.append("Shin\t4.5\t20182931\t\n");
        testString.append("Shin\t4.5\t20182931\t\n");
        testString.append("Shin\t4.5\t20141414\t\n");
        testString.append("Yedarm\t4.5\t20192313\t\n");
        testString.append("Yedarm\t3.8\t20191111\t\n");
        testString.append("Yun\t2.4\t20204141\t\n");
        assertEquals(testString.toString(), database.execute(query).toString());

        query= new String("select * from student order by name desc");
        testString.delete(0, testString.length());
        testString.append("<anonymous>\n");
        testString.append("name\tscore\tid\t");
        testString.append("\n----------------------------------------\n");
        testString.append("Yun\t2.4\t20204141\t\n");
        testString.append("Yedarm\t4.5\t20192313\t\n");
        testString.append("Yedarm\t3.8\t20191111\t\n");
        testString.append("Shin\t4.5\t20182931\t\n");
        testString.append("Shin\t4.5\t20182931\t\n");
        testString.append("Shin\t4.5\t20141414\t\n");
        testString.append("Seok\t3.8\t20162345\t\n");
        testString.append("Gyeong\t4.2\t20155524\t\n");
        assertEquals(testString.toString(), database.execute(query).toString());
    }
    @Test
    void executeOrderby2() throws IOException, ParseFailure {
        String query = new String("select * from student order by name, id");
        testString.append("<anonymous>\n");
        testString.append("name\tscore\tid\t");
        testString.append("\n----------------------------------------\n");
        testString.append("Gyeong\t4.2\t20155524\t\n");
        testString.append("Seok\t3.8\t20162345\t\n");
        testString.append("Shin\t4.5\t20141414\t\n");
        testString.append("Shin\t4.5\t20182931\t\n");
        testString.append("Shin\t4.5\t20182931\t\n");
        testString.append("Yedarm\t3.8\t20191111\t\n");
        testString.append("Yedarm\t4.5\t20192313\t\n");
        testString.append("Yun\t2.4\t20204141\t\n");
        assertEquals(testString.toString(), database.execute(query).toString());

        query = new String("select id from student order by name, id");
        testString.delete(0, testString.length());
        testString.append("<anonymous>\n");
        testString.append("id\t");
        testString.append("\n----------------------------------------\n");
        testString.append("20155524\t\n");
        testString.append("20162345\t\n");
        testString.append("20141414\t\n");
        testString.append("20182931\t\n");
        testString.append("20182931\t\n");
        testString.append("20191111\t\n");
        testString.append("20192313\t\n");
        testString.append("20204141\t\n");
        assertEquals(testString.toString(), database.execute(query).toString());

        query = new String("select * from student order by score desc, name desc");
        testString.delete(0, testString.length());
        testString.append("<anonymous>\n");
        testString.append("name\tscore\tid\t");
        testString.append("\n----------------------------------------\n");
        testString.append("Yedarm\t4.5\t20192313\t\n");
        testString.append("Shin\t4.5\t20182931\t\n");
        testString.append("Shin\t4.5\t20182931\t\n");
        testString.append("Shin\t4.5\t20141414\t\n");
        testString.append("Gyeong\t4.2\t20155524\t\n");
        testString.append("Yedarm\t3.8\t20191111\t\n");
        testString.append("Seok\t3.8\t20162345\t\n");
        testString.append("Yun\t2.4\t20204141\t\n");
        assertEquals(testString.toString(), database.execute(query).toString());
    }

    @Test
    void executeDistinctOrderby() throws IOException, ParseFailure {
        String query = new String("select distinct * from student order by name desc");
        testString.delete(0, testString.length());
        testString.append("<anonymous>\n");
        testString.append("name\tscore\tid\t");
        testString.append("\n----------------------------------------\n");
        testString.append("Yun\t2.4\t20204141\t\n");
        testString.append("Yedarm\t4.5\t20192313\t\n");
        testString.append("Yedarm\t3.8\t20191111\t\n");
        testString.append("Shin\t4.5\t20182931\t\n");
        testString.append("Shin\t4.5\t20141414\t\n");
        testString.append("Seok\t3.8\t20162345\t\n");
        testString.append("Gyeong\t4.2\t20155524\t\n");
        assertEquals(testString.toString(), database.execute(query).toString());

        query = new String("select distinct score from student order by score desc");
        testString.delete(0, testString.length());
        testString.append("<anonymous>\n");
        testString.append("score\t");
        testString.append("\n----------------------------------------\n");
        testString.append("4.5\t\n");
        testString.append("4.2\t\n");
        testString.append("3.8\t\n");
        testString.append("2.4\t\n");
        assertEquals(testString.toString(), database.execute(query).toString());

        query = new String("select distinct score from student where student.score < 4.0 order by score ");
        testString.delete(0, testString.length());
        testString.append("<anonymous>\n");
        testString.append("score\t");
        testString.append("\n----------------------------------------\n");
        testString.append("2.4\t\n");
        testString.append("3.8\t\n");
        assertEquals(testString.toString(), database.execute(query).toString());

        query = new String("select distinct name, id from student where student.score < 4.0 order by score ");
        testString.delete(0, testString.length());
        testString.append("<anonymous>\n");
        testString.append("name\tid\t");
        testString.append("\n----------------------------------------\n");
        testString.append("Yun\t20204141\t\n");
        testString.append("Seok\t20162345\t\n");
        testString.append("Yedarm\t20191111\t\n");
        assertEquals(testString.toString(), database.execute(query).toString());
    }
}