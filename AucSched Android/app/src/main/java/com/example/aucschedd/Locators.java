package com.example.aucschedd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class Locators extends AppCompatActivity {


    Spinner spinner_parent, spinner_child;
    ArrayList<String> arrList_parent;
    ArrayAdapter<String> arrAdapter_parent;

    ArrayList<String> arrList_Build, arrList_dep, arrList_adv;
    ArrayAdapter<String> arrAdapter_child;

    public String Selection="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locators);

        spinner_parent = (Spinner)findViewById(R.id.spinner_parent);
        spinner_child = (Spinner)findViewById(R.id.spinner_child);

        arrList_parent = new ArrayList<>();
        arrList_parent.add("Buildings");
        arrList_parent.add("Departments");
        arrList_parent.add("Advising");

        arrAdapter_parent = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrList_parent);
        spinner_parent.setAdapter(arrAdapter_parent);

        //========= child spinner process starts ============

        arrList_Build= new ArrayList<>();
        arrList_Build.add("Administration Building");
        arrList_Build.add("AUC Center for the Arts");
        arrList_Build.add("AUC Park and Square");
        arrList_Build.add("Abdul Latif Jameel Hall");
        arrList_Build.add("Bartlett Plaza");
        arrList_Build.add("Campus Centre");
        arrList_Build.add("Hatem and Janet Mostafa Core Academic Center");
        arrList_Build.add("University Garden");
        arrList_Build.add("AUC Library");
        arrList_Build.add("Research Centers Building");
        arrList_Build.add("Prince Alwaleed Bin Talal Bin Abdulaziz Alsaud Hall");
        arrList_Build.add("School of Sciences and Engineering");
        arrList_Build.add("AUC Sports Center");
        arrList_Build.add("University Residences");
        arrList_Build.add("Students' Court");
        arrList_Build.add("The Watson House");

        arrList_dep= new ArrayList<>();
        arrList_dep.add("Computer Engineering");
        arrList_dep.add("Business");
        arrList_dep.add("History");

        arrList_adv= new ArrayList<>();
        arrList_adv.add("Undeclared");
        arrList_adv.add("Declared");
        TextView tx1 =(TextView)findViewById(R.id.textView8);
        Button Btn = (Button) findViewById(R.id.Btn);
        spinner_parent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {



                if (position==0)
                {
                    arrAdapter_child= new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrList_Build);
                }
                if (position==1)
                {
                    arrAdapter_child= new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrList_dep);
                }
                if (position==2)
                {
                    arrAdapter_child= new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrList_adv);
                }
                spinner_child.setAdapter(arrAdapter_child);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner_child.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Selection = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //========= child spinner process ends ============

        Button goBtn = (Button) findViewById(R.id.goBtn);

        goBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= null;

                if(Selection.equals("Administration Building"))
                {
                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("geo:30.02114314956096, 31.49915429439435"));
                    startActivity(intent);
                }
                if(Selection.equals("AUC Center for the Arts"))
                {
                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("geo:30.022244343728886, 31.497997812510622"));
                    startActivity( intent);
                }
                if(Selection.equals("AUC Park and Square"))
                {
                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("geo:30.031127438664818, 31.500943964375967"));
                    startActivity( intent);
                }
                if(Selection.equals("Abdul Latif Jameel Hall"))
                {
                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("geo:30.01871638321542, 31.499360217416942"));
                    startActivity( intent);
                }
                if(Selection.equals("Bartlett Plaza"))
                {

                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("geo:30.019641062736767, 31.49961581710155"));
                    startActivity( intent);
                }
                if(Selection.equals("Campus Centre"))
                {

                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("geo: 30.01862664374694, 31.503204906006175"));
                    startActivity( intent);
                }
                if(Selection.equals("Hatem and Janet Mostafa Core Academic Center"))
                {

                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("geo: 30.020265234317847, 31.499544481229698"));
                    startActivity( intent);
                }
                if(Selection.equals("University Garden"))
                {

                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("geo:30.020540076339792, 31.500990530808117"));
                    startActivity(   intent);
                }
                if(Selection.equals("AUC Library"))
                {

                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("geo:30.019904884734913, 31.500087631559154"));
                    startActivity( intent);
                }
                if(Selection.equals("Research Centers Building"))
                {

                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("geo:30.021884449057563, 31.498685119433432"));
                    startActivity( intent);
                }
                if(Selection.equals("Prince Alwaleed Bin Talal Bin Abdulaziz Alsaud Hall"))
                {

                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("geo:30.02150507118378, 31.49852871957462"));
                    startActivity( intent);
                }
                if(Selection.equals("School of Sciences and Engineering"))
                {

                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("geo:30.020160314752513, 31.49893615777051"));
                    startActivity( intent);
                }
                if(Selection.equals("AUC Sports Center"))
                {

                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("geo:30.01812133043774, 31.503316530368256"));
                    startActivity( intent);
                }
                if(Selection.equals("University Residences"))
                {

                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("geo:30.01919028931579, 31.502387203083853"));
                    startActivity( intent);
                }
                if(Selection.equals("Students' Court"))
                {

                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("geo:30.01899250948799, 31.500790610497305"));
                    startActivity(   intent);
                }
                if(Selection.equals("The Watson House"))
                {

                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("geo: 30.022975460973182, 31.499417340381665"));
                    startActivity(   intent);
                }
                if(Selection.equals("Computer Engineering"))
                {


                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("geo:30.019015753822007, 31.503401761859955"));
                    startActivity(   intent);
                }
                if(Selection.equals("Business"))
                {

                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("geo:30.01865683238792, 31.49930281042508"));
                    startActivity(   intent);
                }
                if(Selection.equals("Art"))
                {
                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("geo:30.022244343728886, 31.497997812510622"));
                    startActivity(   intent);
                }
                if(Selection.equals("Undeclared"))
                {

                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("geo:30.0208610649863, 31.498917025943"));
                    startActivity(   intent);
                }
                if(Selection.equals("Declared"))
                {
                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("geo: 30.019015753822007, 31.503401761859955"));
                    startActivity(   intent);
                }

            }
        });

        Btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                if(Selection.equals("Administration Building"))
                {
                    tx1.setText("Located right beside Building for Arts: Administration Building houses key administrative offices addressing a wide range of student and staff needs.");

                }
                if(Selection.equals("AUC Center for the Arts"))
                {
                    tx1.setText("Located at the South end of the campus, go from Quick market South. The AUC Center for the Arts includes facilities for art, film and theatre students, and hosts exhibitions and educational programs with a focus on contemporary art in the Middle East and North Africa as well as classic and modern theatre productions.");

                }
                if(Selection.equals("AUC Park and Square"))
                {

                    tx1.setText("The main entrance to the University, AUC Park and Square offers key resources to prospective and current students in the campus information center. This area also houses AUC’s School of Continuing Education situated on a scenic section of the AUC New Cairo campus.");
                }
                if(Selection.equals("Abdul Latif Jameel Hall"))
                {

                    tx1.setText("Also named 'BEC' One of the main buildings on campus, the Abdul Latif Jameel Hall includes both the School of Business and the School of Global Affairs and Public Policy, the first schools of their kind in Egypt and the Middle East. ");

                }
                if(Selection.equals("Bartlett Plaza"))
                {
                    tx1.setText("A 150-meter-long space, the plaza is the principal outdoor location for AUC’s largest events including commencements and alumni homecomings. The plaza is also a place for students to showcase the wide variety of clubs and extracurricular activities and recruit members to make their AUC experience balanced, interesting and rewarding.");

                }
                if(Selection.equals("Campus Centre"))
                {
                    tx1.setText("The Campus Center includes a number of large meeting spaces, indoor and outdoor recreational spaces and most of AUC’s student-focused activities and resources, including the Student Union and the food court, as well as the bookstore, copy center, gift shop and travel office.");

                }
                if(Selection.equals("Hatem and Janet Mostafa Core Academic Center"))
                {

                    tx1.setText("Also named 'CORE building' The Hatem and Janet Mostafa Core Academic Center houses the largest lecture hall on campus, as well as classrooms and student advising for AUC’s Core Curriculum program. ");

                }
                if(Selection.equals("University Garden"))
                {
                    tx1.setText("In this sustainable landscape, the University extends its classrooms beyond the campus buildings to the environment and ecology of the site itself and provides a popular space for all members of the AUC community to enjoy at their leisure.");

                }
                if(Selection.equals("AUC Library"))
                {
                    tx1.setText("With space for more than 700,000 volumes and periodical subscriptions, more than 22,000 e-books and 84 databases, the library supports the instructional and research needs of the AUC community and provides access to resources, information and services for students, faculty members and scholars globally. ");
                }
                if(Selection.equals("Research Centers Building"))
                {

                    tx1.setText("The Research Centers Building houses some of the University's 13 research centers that boast an active agenda of research ranging from migration and refugee studies, women’s rights, economics and business case studies.");

                }
                if(Selection.equals("Prince Alwaleed Bin Talal Bin Abdulaziz Alsaud Hall"))
                {
                    tx1.setText("Housed in the Prince Alwaleed Bin Talal Bin Abdulaziz Alsaud Hall, HUSS focuses on developing students’ critical thinking and analytical skills while encouraging students to explore creative approaches to problem-solving. ");

                }
                if(Selection.equals("School of Sciences and Engineering"))
                {
                    tx1.setText("SSE Building Where Dreams go to die! :D The largest building in size of the six schools, SSE contains 145 laboratories supporting biology, physics, chemistry, computer science, biotechnology and nanotechnology, as well as two research centers. The school offers courses that provide hands-on experience in the classroom and gives students a solid foundation in scientific and engineering practices.");

                }
                if(Selection.equals("AUC Sports Center"))
                {
                    tx1.setText("AUC's sports facilities offer quality athletic activities for students, faculty, staff and alumni. The programs promote a healthy lifestyle, discipline, teamwork and leadership development, as well as high standards of ethical conduct and sportsmanship. ");

                }
                if(Selection.equals("University Residences"))
                {

                    tx1.setText("More than 450 students take advantage of convenient on-campus accommodation. The residences are situated among palm groves, gardens and small courtyards, and are intended to resemble a village or group of townhouses. They are close to classes and all University campus activities and facilities.");

                }
                if(Selection.equals("Students' Court"))
                {

                    tx1.setText("Located between the Administration Building and the School of Sciences and Engineering, the Students’ Court is where most students relax, socialize and study during assembly hour or between classes. ");

                }
                if(Selection.equals("The Watson House"))
                {

                    tx1.setText("The Watson House, located at the main entrance to AUC New Cairo, is a fully-equipped executive meeting facility designated for presidential events and other important administrative purposes.");

                }
                if(Selection.equals("Computer Engineering"))
                {

                    tx1.setText("Go to the SSE building located near Quick Mart, then go to the second floor this is where the Computer Science and Engineering department, labs and offices are.");

                }
                if(Selection.equals("Business"))
                {

                    tx1.setText("Located in the BEC building near Four palms and the food court ");

                }
                if(Selection.equals("Art"))
                {
                    tx1.setText("Located in the School of Arts building");

                }
                if(Selection.equals("Undeclared"))
                {

                    tx1.setText("Please head to Mrs. Rabbab's office");

                }
                if(Selection.equals("Declared"))
                {
                    tx1.setText("Please Head to Mrs.Noha's office");

                }
            }


        });
    }
}
