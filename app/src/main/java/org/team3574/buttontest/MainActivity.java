package org.team3574.buttontest;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class MainActivity extends ActionBarActivity {

    Integer count = 0;
    Integer count2 = 0;
    Integer count3 = 0;
    Integer count4 = 0;
    Integer count5 = 0;
    Integer count6 = 0;
    Integer plusMinus = 1;
    Integer filecount = 0;
    final static String CSVHeader = "Team, Send, Fish, Pie, Money, Cookie, Button";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ToggleButton subtract = (ToggleButton) findViewById(R.id.toggleButton);
        final Button button = (Button) findViewById(R.id.button);
        final Button button2 = (Button) findViewById(R.id.button2);
        final Button button3 = (Button) findViewById(R.id.button3);
        final Button button4 = (Button) findViewById(R.id.button4);
        final Button button5 = (Button) findViewById(R.id.button5);
        final Button button6 = (Button) findViewById(R.id.button6);
        final EditText teamField = (EditText) findViewById(R.id.teamNumber);


        subtract.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                plusMinus = plusMinus * -1;
            }
        });

//        if (subtract == false) {
//
//        }

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                count = count + plusMinus;
                TextView view = (TextView) findViewById(R.id.textView);
                view.setText(count.toString());
            }
        });

        final TextView view2 = (TextView) findViewById(R.id.textView2);
        count2 = Integer.parseInt(view2.getText().toString());
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                count2 = count2 + plusMinus;
                view2.setText(count2.toString());
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                count3 = count3 + plusMinus;
                TextView view3 = (TextView) findViewById(R.id.textView3);
                view3.setText(count3.toString());
            }
        });

        final TextView view4 = (TextView) findViewById(R.id.textView4);
        count4 = Integer.parseInt(view4.getText().toString());
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                count4 = count4 + plusMinus;
                view4.setText(count4.toString());
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                count5 = count5 + plusMinus;
                TextView view5 = (TextView) findViewById(R.id.textView5);
                view5.setText(count5.toString());
            }
        });

        final TextView view6 = (TextView) findViewById(R.id.textView6);
        count6 = Integer.parseInt(view6.getText().toString());
        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                count6 = count6 + plusMinus;
                view6.setText(count6.toString());
            }
        });

        final Button buttonSave = (Button) findViewById(R.id.save_button);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                File file = new File(Environment.getExternalStorageDirectory() +
                        File.separator + "scouting_output.csv");
                try {
                    FileWriter filewriter = new FileWriter(file, true);
                    BufferedWriter out = new BufferedWriter(filewriter);

                    if (!file.exists()) {
                        file.createNewFile();
                        out.append(CSVHeader);
                        out.newLine();
                    }

                    String info = "" + teamField.getText().toString() +
                            "," + count.toString() +
                            "," + count2.toString() +
                            "," + count3.toString() +
                            "," + count4.toString() +
                            "," + count5.toString() +
                            "," + count6.toString();
                    out.append(info);
                    out.newLine();

                    out.close();
                    filewriter.close();

                    filecount++;
                } catch (IOException e) {
                    e.getStackTrace();
                    e.printStackTrace();
                    android.util.Log.d("failed to save file", e.toString());
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Called when the user clicks the Send button
     */
    public void sendMessage(View view) {
        // Do something in response to button
        count++;
        getString(R.string.text_1);
//        R.string.text_1 = count;
    }

    /* Checks if external storage is available for read and write */
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    /* Checks if external storage is available to at least read */
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }

    public void makeFile(String albumName) {
//        // Get the directory for the user's public pictures directory.
//        File file = new File(Environment.getExternalStoragePublicDirectory(
//                Environment.DIRECTORY_PICTURES), albumName);
//        if (!file.mkdirs()) {
//            Log.e("LOG_TAG", "Directory not created");
//        }
//        return file;

        try { // catches IOException below
            final String TESTSTRING = new String("Hello Android");

            // ##### Write a file to the disk #####
                        /* We have to use the openFileOutput()-method
                         * the ActivityContext provides, to
                         * protect your file from others and
                         * This is done for security-reasons.
                         * We chose MODE_WORLD_READABLE, because
                         *  we have nothing to hide in our file */
            FileOutputStream fOut = openFileOutput("samplefile.txt", MODE_MULTI_PROCESS);
            OutputStreamWriter osw = new OutputStreamWriter(fOut);

            // Write the string to the file
            osw.write(TESTSTRING);
                        /* ensure that everything is
                         * really written out and close */
            osw.flush();
            osw.close();
            // ##### Read the file back in #####

                        /* We have to use the openFileInput()-method
                         * the ActivityContext provides.
                         * Again for security reasons with
                         * openFileInput(...) */
            FileInputStream fIn = openFileInput("samplefile.txt");
            InputStreamReader isr = new InputStreamReader(fIn);
                        /* Prepare a char-Array that will
                         * hold the chars we read back in. */
            char[] inputBuffer = new char[TESTSTRING.length()];
            // Fill the Buffer with data from the file
            isr.read(inputBuffer);
            // Transform the chars to a String
            String readString = new String(inputBuffer);

            // Check if we read back the same chars that we had written out
            boolean isTheSame = TESTSTRING.equals(readString);

            // WOHOO lets Celebrate =)
            Log.i("File Reading stuff", "success = " + isTheSame);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

//    public File makeFile() {
//        File file = new File(Environment.getExternalStorageDirectory() + File.separator + "test.txt");
//        file.createNewFile();
//        String[] data1={1,1,0,0};
////write the bytes in file
//        if(file.exists())
//        {
//            OutputStream fo = new FileOutputStream(file);
//            fo.write(data1);
//            fo.close();
//            System.out.println("file created: "+file);
//            url = upload.upload(file);
//        }
//
////deleting the file
//        file.delete();
//        System.out.println("file deleted");
//    }

}
