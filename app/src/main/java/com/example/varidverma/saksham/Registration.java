package com.example.varidverma.saksham;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class Registration extends AppCompatActivity {

    Button reg_btn;
    EditText fname,lname,phone,email,dob,city,password,confirmpassword;
    String first_name,last_name,email_id,City,Dob,Password,ConfirmPassword,Mobile_no;
    AlertDialog.Builder builder;
    String reg_url = "http://192.168.232.1/register.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        reg_btn = (Button)findViewById(R.id.regis);
        fname = (EditText) findViewById(R.id.fname);
        lname = (EditText) findViewById(R.id.lname);
        phone = (EditText) findViewById(R.id.phone);
        email = (EditText) findViewById(R.id.email);
        dob = (EditText) findViewById(R.id.dob);
        city = (EditText) findViewById(R.id.city);
        password = (EditText) findViewById(R.id.pass);
        confirmpassword = (EditText) findViewById(R.id.pass2);
        builder = new AlertDialog.Builder(Registration.this);

        reg_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                first_name = fname.getText().toString();
                last_name = lname.getText().toString();
                email_id = email.getText().toString();
                Dob = dob.getText().toString();
                City = city.getText().toString();
                Password = password.getText().toString();
                ConfirmPassword = confirmpassword.getText().toString();
                Mobile_no = phone.getText().toString();

                if(first_name.equals("") || last_name.equals("") || email_id.equals("") || city.equals("") || dob.equals("") || Password.equals("") || ConfirmPassword.equals("")){
                    builder.setTitle("Something Went Wrong ");
                    builder.setMessage("Please fill all the fields");
                   displayAlert("Input Error");
                }
                else{
                    if(!(Password.equals(ConfirmPassword))){
                        builder.setTitle("Something Went wrong");
                        builder.setMessage("Password are nor matching");
                        displayAlert("Input Error");
                    }
                    else {
                        StringRequest stringRequest = new StringRequest(Request.Method.POST, reg_url, new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }){
                            @Override
                            protected Map<String, String> getParams() throws AuthFailureError{
                                Map<String, String> params  = new HashMap<String, String>();
                                params.put();
                                return super.getParams();
                            }
                        };
                    }
                }
            }
        });
    }
    public void  displayAlert(final String code){
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener(){
            @Override
            public  void onClick(DialogInterface dialog, int Which){
                if (code.equals("Input Error")){
                    password.setText("");
                    confirmpassword.setText("");
                }
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
