package com.project.pagefaultfinder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Main8Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        Bundle b= getIntent().getExtras();
        int f = b.getInt("f",3);
        int n = b.getInt("n",10);
        String str = b.getString("str");
        calculate(f,n,str);
    }

    public void calculate(int f,int n,String str)
    {

        TextView result = (TextView) findViewById(R.id.result);
        result.setText("");
        result.append("FCFS\n");
        int page=0,ch=1,pgf=0,chn=0;
        boolean flag;
        int pages[]; //pgf-page fault
                    /*System.out.println("Menu");
                    System.out.println("1.FIFO");
                    System.out.println("2.LRU");
                    System.out.println("3.LFU");
                    System.out.println("4.EXIT");
                    System.out.println("ENTER YOUR CHOICE: ");*/
        //ch=Integer.parseInt(obj.readLine());
        int pt=0;

        //System.out.println("enter no. of frames: ");
        //f=Integer.parseInt(obj.readLine());
        int frame[]=new int[f];
        for(int i=0;i<f;i++)
        {
            frame[i]=-1;
        }
        //System.out.println("enter the no of pages ");
        //n=Integer.parseInt(obj.readLine());//////
        pages=new int[n];
        //System.out.println("enter the page no ");
        for(int j=0;j<n;j++)
            //pages[j]=Integer.parseInt(obj.readLine());
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
                    //System.out.print("frame :");
                    result.append("Frame: ");
                    for(int j=0;j<f;j++) {
                        result.append(frame[j]+" ");
                        //System.out.print(frame[j] + " ");
                    }
                    //System.out.println();
                    pgf++;
                }
                else
                {
                    //System.out.print("frame :");
                    result.append("Frame: ");
                    for(int j=0;j<f;j++) {
                        //System.out.print(frame[j] + " ");
                        result.append(frame[j]+" ");
                    }
                    //System.out.println();
                }
                result.append("\n");
                chn++;
            }
        }while(chn!=n);
        //System.out.println("Page fault:"+pgf);
        result.append("Page fault: "+pgf);
        result.append("\n\nLRU\n");

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
                    //Log.d("dkkfjhdskfjs",page+" "+frame1[j]);
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
                    //System.out.println("frame :" );
                    result.append("Frame : ");
                    for(int j=0;j<f;j++) {
                        //System.out.print(frame1[j] + " ");   //////
                        result.append(frame1[j]+" ");
                    }
                    pgf++;
                    //System.out.println();
                    result.append("\n");
                }
                else
                {
                    //System.out.println("frame :" );
                    result.append("Frame : ");
                    for(int j=0;j<f;j++) {
                        //System.out.print(frame1[j] + " ");  ///
                        result.append(frame1[j]+" ");
                    }
                    //System.out.println();
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
        //System.out.println("Page fault:"+pgf);
        result.append("Page fault: "+pgf);
        result.append("\n\nOPR\n");



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
                    //System.out.print("frame :");
                    result.append("Frame : ");
                    for(int j=0;j<f;j++)
                    {
                        //System.out.print(frame2[j]+" ");
                        result.append(frame2[j]+" ");
                        //System.out.println();
                        Log.d("pgf",pgf+" ");
                        //pgf++;
                    }
                    result.append("\n");
                    pgf++;
                }
                else
                {
                    //System.out.print("frame :");
                    result.append("Frame : ");
                    for(int j=0;j<f;j++) {
                        //System.out.print(frame2[j] + " ");
                        result.append(frame2[j]+" ");
                    }
                    //System.out.println();
                    result.append("\n");

                }
                chn++;
            }
        }while(chn!=n);
        //System.out.println("Page fault:"+pgf);
        result.append("Page fault: "+pgf);

    }

}
