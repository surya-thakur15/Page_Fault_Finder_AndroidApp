package com.project.pagefaultfinder;

import android.content.Intent;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main7Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

    }


    public void a(View view)
    {
       EditText frames = (EditText) findViewById(R.id.editText);
        EditText pagess = (EditText) findViewById(R.id.editText3);
        EditText pageno = (EditText) findViewById(R.id.editText5);
        int f = Integer.parseInt(frames.getText().toString());
        int n = Integer.parseInt(pagess.getText().toString());
        String str = pageno.getText().toString();

        Intent i = new Intent(this,Main8Activity.class);
        i.putExtra("f",f);
        i.putExtra("n",n);
        i.putExtra("str",str);
        startActivity(i);
    }
    public void calculate(View view)
    {

        EditText frames = (EditText) findViewById(R.id.editText);
        EditText pagess = (EditText) findViewById(R.id.editText3);
        EditText pageno = (EditText) findViewById(R.id.editText5);
        TextView result = (TextView) findViewById(R.id.result);

        result.setText("");
        result.append("FCFS\n");
                int f,page=0,ch=1,pgf=0,n,chn=0;
                boolean flag;
                int pages[];
                            int pt=0;


                            f = Integer.parseInt(frames.getText().toString());
                            int frame[]=new int[f];
                            for(int i=0;i<f;i++)
                            {
                                frame[i]=-1;
                            }

                            n = Integer.parseInt(pagess.getText().toString());
                            pages=new int[n];

                            String str = pageno.getText().toString();

                            for(int j=0;j<n;j++)

                                pages[j]=Integer.parseInt(Character.toString(str.charAt(j)));




                            do{
                                int pg=0;
                                for(pg=0;pg<n;pg++)
                                {

                                    page=pages[pg];
                                    flag=true;
                                    for(int j=0;j<f;j++)
                                    {
                                        if(page==frame[j])
                                        {
                                            flag=false;
                                            break;
                                        }
                                    }
                                    if(flag)
                                    {
                                        frame[pt]=page;
                                        pt++;
                                        if(pt==f)
                                            pt=0;

                                        result.append("frame: ");
                                        for(int j=0;j<f;j++) {
                                            result.append(frame[j]+" ");

                                        }

                                        pgf++;
                                    }
                                    else
                                    {

                                        result.append("\n frame: ");
                                        for(int j=0;j<f;j++) {

                                            result.append(frame[j]+" ");
                                        }

                                    }

                                    chn++;
                                }
                            }while(chn!=n);

                            result.append("Page fault:"+pgf);
        result.append("\nLRU\n");

        page=0;
        chn=0;
        int k=0;
        pgf=0;
                            int frame1[]=new int[f];
                            int a[]=new int[f];
                            int b[]=new int[f];
                            for(int i=0;i<f;i++)
                            {
                                frame1[i]=-1;
                                a[i]=-1;
                                b[i]=-1;
                            }
                            do{
                                int pg=0;
                                for(pg=0;pg<n;pg++)
                                {
                                    page=pages[pg];
                                    flag=true;
                                    for(int j=0;j<f;j++)
                                    {

                                        if(page==frame1[j])
                                        {flag=false; break;}
                                    }

                                    for(int j=0;j<f && flag;j++)
                                    {
                                        if(frame1[j]==a[f-1])
                                        {k=j;
                                            break;}
                                    }

                                    if(flag)
                                    {
                                        frame1[k]=page;

                                        result.append("frame :\n");
                                        for(int j=0;j<f;j++) {

                                            result.append(frame1[j]+" ");
                                        }
                                        pgf++;

                                        result.append("\n");
                                    }
                                    else
                                    {

                                        result.append("frame :\n");
                                        for(int j=0;j<f;j++) {

                                            result.append(frame1[j]+" ");
                                        }

                                        result.append("\n");
                                    }
                                    int p=1;
                                    b[0]=page;
                                    for(int j=0;j<a.length;j++)
                                    {
                                        if(page!=a[j] && p<f)
                                        {
                                            b[p]=a[j];
                                            p++;
                                        }
                                    }
                                    for(int j=0;j<f;j++)
                                    {
                                        a[j]=b[j];
                                    }
                                    chn++;

                                }
                            }while(chn!=n);

        result.append("Page fault:"+pgf);
        result.append("\nOPR\n");



        page=0;
                            k=0;
        chn=0;
                            pgf=0;
                            int sml;
                            int frame2[]=new int[f];
                            int cnt[]=new int [f];
                            flag=true;

                            for(int i=0;i<f;i++)
                            {
                                frame2[i]=-1;
                                cnt[i]=0;
                            }
                            do
                            {
                                int pg=0;
                                for(pg=0;pg<n;pg++)
                                {
                                    page=pages[pg];
                                    flag=true;


                                    for(int j=0;j<f;j++)
                                    {
                                        if(page==frame2[j])
                                        {
                                            flag=false;
                                            cnt[j]++;
                                            break;
                                        }
                                    }
                                    if(flag)
                                    {

                                        sml=cnt[0];
                                        for(int j=0;j<f;j++)
                                        {
                                            if(cnt[j]<sml)
                                            {
                                                sml=cnt[j];
                                                break;
                                            }
                                        }
                                        for(int j=0;j<f;j++)
                                        {
                                            if(sml==cnt[j] )
                                            {
                                                frame2[j]=page;
                                                k=j;
                                                break;
                                            }
                                        }
                                        cnt[k]=1;

                                        result.append("frame :");
                                        for(int j=0;j<f;j++)
                                        {

                                            result.append(frame2[j]+" \n");

                                            Log.d("pgf",pgf+" ");

                                        }
                                        pgf++;
                                    }
                                    else
                                    {

                                        result.append("frame :");
                                        for(int j=0;j<f;j++) {

                                            result.append(frame2[j]+" ");
                                        }

                                        result.append("\n");

                                    }
                                    chn++;
                                }
                            }while(chn!=n);

                            result.append("Page fault:"+pgf);

            }



}
