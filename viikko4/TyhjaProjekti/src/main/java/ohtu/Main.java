package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        // vaihda oma opiskelijanumerosi seuraavaan, ÄLÄ kuitenkaan laita githubiin omaa opiskelijanumeroasi
        String studentNr = "014484900";
        if ( args.length>0) {
            studentNr = args[0];
        }

        String url = "http://ohtustats2017.herokuapp.com/students/"+studentNr+"/submissions";
        
        String url2 = "https://ohtustats2017.herokuapp.com/courses/1.json";

        String bodyText = Request.Get(url).execute().returnContent().asString();
        String bodyText2 = Request.Get(url2).execute().returnContent().asString();
        
        System.out.println("json-muotoinen data:");
        System.out.println( bodyText );

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);
        Submission[] courseInfo = mapper.fromJson(bodyText2, Submission[].class);
         
        System.out.println("Viikot:");
        for (Submission submission : subs) {
            System.out.println(submission);
        }

    }
}