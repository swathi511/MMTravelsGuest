package com.hjsoftware.mmtravelsguest.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.hjsoftware.mmtravelsguest.R;
import com.hjsoftware.mmtravelsguest.SessionManager;
import com.hjsoftware.mmtravelsguest.model.Changepassword;
import com.hjsoftware.mmtravelsguest.webservices.API;
import com.hjsoftware.mmtravelsguest.webservices.RestClient;
import com.google.gson.JsonObject;
import java.util.HashMap;
import retrofit2.Callback;
import retrofit2.Response;
public class ChangePasswordFragment extends Fragment {

    View v;
    EditText newpassword,cpassword;
    Button save;
    String npassword,cnpassword;
    API REST_CLIENT;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "SharedPref";
    SessionManager session;
    String uname;
    HashMap<String, String> user;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v= inflater.inflate(R.layout.change_password, container, false);
        REST_CLIENT= RestClient.get();
        pref = getActivity().getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
        session=new SessionManager(getContext());
        newpassword=(EditText)v.findViewById(R.id.edit_newpassword);
        cpassword=(EditText)v.findViewById(R.id.editconfirmpassword);
        save=(Button)v.findViewById(R.id.button_save);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                npassword=newpassword.getText().toString();
                cnpassword=cpassword.getText().toString();
                if(npassword.equals(""))
                {
                     newpassword.setError("Enter Password");
                }
                else if(cnpassword.equals(""))
                {
                     cpassword.setError("Confirm password");
                }
                else if(!npassword.equals(cnpassword))
                {
                     cpassword.setError("password not matching");
                }

                else{
                    String custemorIds=pref.getString("customerId",null);

                    JsonObject v=new JsonObject();
                    v.addProperty("customerid",custemorIds);
                    v.addProperty("pwd",npassword);
                    retrofit2.Call<Changepassword>password=REST_CLIENT.passwordinfo(v);
                    password.enqueue(new Callback<Changepassword>() {

                        Changepassword changepasword;
                        @Override
                        public void onResponse(retrofit2.Call<Changepassword> call, Response<Changepassword> response) {

                            if(response.isSuccessful()){


                                changepasword =response.body();
                                newpassword.setText("");
                                cpassword.setText("");
                                session.createLoginSession(uname,npassword);
                                Toast.makeText(getContext(),"Password changed successfully!",Toast.LENGTH_LONG).show();



                                // Log.i("hellllo   Responseee is",changepasword.getPwd());
                            }
                            else{
                            }
                        }

                        @Override
                        public void onFailure(retrofit2.Call<Changepassword> call, Throwable t) {

                            Toast.makeText(getActivity(),"Please check Internet connection!",Toast.LENGTH_SHORT).show();

                        }
                    });
                }

            }
        });
        return  v;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        session=new SessionManager(getActivity());
        user = session.getUserDetails();
        uname=user.get(SessionManager.KEY_NAME);


    }

}
