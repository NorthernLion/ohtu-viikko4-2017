package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException, NoSuchFieldException {
        // vaihda oma opiskelijanumerosi seuraavaan, ÄLÄ kuitenkaan laita githubiin omaa opiskelijanumeroasi
        String studentNr = "";
        if (studentNr.length() == 0) {
            System.out.println("toimii vain validilla opiskelijanumerolla!");
        } else {
        if ( args.length>0) {
            studentNr = args[0];
        }

        String url = "http://ohtustats2017.herokuapp.com/students/"+studentNr+"/submissions";

        String bodyText = Request.Get(url).execute().returnContent().asString();
        
        String url2 = "https://ohtustats2017.herokuapp.com/courses/1.json";
        
        String bodyText2 = Request.Get(url2).execute().returnContent().asString();
        

//        System.out.println("json-muotoinen data:");
//        System.out.println( bodyText );

        int hoursAll = 0;
        int tasksAll = 0;

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);
        Course course = mapper.fromJson(bodyText2, Course.class);
        for (Submission submission : subs) {
            submission.taskCounter();
            hoursAll += submission.getHours();
            tasksAll += submission.getTotalTasksDone();
        }
        System.out.println("Kurssi: " + course);
        System.out.println("");
        System.out.println("Opiskelija numero: " + subs[0].getStudent_number()) ;
        System.out.println("");
        for (Submission submission : subs) {
            System.out.println(submission);
        }
        System.out.println("");
        System.out.println("yhteensa: " + tasksAll + " tehtavaa " + hoursAll + " tuntia");
        }
    }
}