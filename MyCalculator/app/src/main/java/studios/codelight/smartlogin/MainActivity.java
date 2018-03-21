package studios.codelight.smartlogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import studios.codelight.smartloginlibrary.LoginType;
import studios.codelight.smartloginlibrary.SmartLogin;
import studios.codelight.smartloginlibrary.SmartLoginCallbacks;
import studios.codelight.smartloginlibrary.SmartLoginConfig;
import studios.codelight.smartloginlibrary.SmartLoginFactory;
import studios.codelight.smartloginlibrary.UserSessionManager;
import studios.codelight.smartloginlibrary.users.SmartFacebookUser;
import studios.codelight.smartloginlibrary.users.SmartGoogleUser;
import studios.codelight.smartloginlibrary.users.SmartUser;
import studios.codelight.smartloginlibrary.util.SmartLoginException;


public class MainActivity extends AppCompatActivity implements SmartLoginCallbacks {

    private Button facebookLoginButton, googleLoginButton, customSigninButton, customSignupButton, logoutButton;
    private EditText emailEditText, passwordEditText, calculatorRes;
    private RelativeLayout calculator;
    SmartUser currentUser;
    //GoogleApiClient mGoogleApiClient;
    SmartLoginConfig config;
    SmartLogin smartLogin;
    private Button num0;
    private Button num1;
    private Button num2;
    private Button num3;
    private Button num4;
    private Button num5;
    private Button num6;
    private Button num7;
    private Button num8;
    private Button num9;
    private Button plus_btn;
    private Button subtract_btn;
    private Button multiply_btn;
    private Button divide_btn;
    private Button equal_btn;
    private Button dot_btn;
    private Button percent_btn;
    private Button delete_btn;
    private Button ac_btn;
    private Button sin_btn;
    private Button cos_btn;
    private Button tan_btn;
    private EditText mResultText;
    private String existedText = "";
    private boolean isCounted = false;
    private boolean startWithOperator = false;
    private boolean startWithSubtract = false;
    private boolean noStartWithOperator = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
//        initEvent();
        setListeners();

        config = new SmartLoginConfig(this, this);
        config.setFacebookAppId(getString(R.string.facebook_app_id));
        config.setFacebookPermissions(null);
        config.setGoogleApiClient(null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        currentUser = UserSessionManager.getCurrentUser(this);
        refreshLayout();
    }

    private void refreshLayout() {
        currentUser = UserSessionManager.getCurrentUser(this);
        if (currentUser != null) {
            Log.d("Smart Login", "Logged in user: " + currentUser.toString());
            facebookLoginButton.setVisibility(View.GONE);
            googleLoginButton.setVisibility(View.GONE);
            customSigninButton.setVisibility(View.GONE);
            customSignupButton.setVisibility(View.GONE);
            emailEditText.setVisibility(View.GONE);
            passwordEditText.setVisibility(View.GONE);
            logoutButton.setVisibility(View.VISIBLE);
            calculatorRes.setVisibility(View.VISIBLE);
            calculator.setVisibility(View.VISIBLE);
        } else {
            facebookLoginButton.setVisibility(View.VISIBLE);
            googleLoginButton.setVisibility(View.VISIBLE);
            customSigninButton.setVisibility(View.VISIBLE);
            customSignupButton.setVisibility(View.VISIBLE);
            emailEditText.setVisibility(View.VISIBLE);
            passwordEditText.setVisibility(View.VISIBLE);
            logoutButton.setVisibility(View.GONE);
            calculatorRes.setVisibility(View.GONE);
            calculator.setVisibility(View.GONE);
//            calculatorTableLayout.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (smartLogin != null) {
            smartLogin.onActivityResult(requestCode, resultCode, data, config);
        }
    }

    private void setListeners() {
        facebookLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform Facebook login
                smartLogin = SmartLoginFactory.build(LoginType.Facebook);
                smartLogin.login(config);
            }
        });

        googleLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform Google login
                smartLogin = SmartLoginFactory.build(LoginType.Google);
                smartLogin.login(config);
            }
        });

        customSigninButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform custom sign in
                smartLogin = SmartLoginFactory.build(LoginType.CustomLogin);
                smartLogin.login(config);
            }
        });

        customSignupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform custom sign up
                smartLogin = SmartLoginFactory.build(LoginType.CustomLogin);
                smartLogin.signup(config);
            }
        });

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentUser != null) {
                    if (currentUser instanceof SmartFacebookUser) {
                        smartLogin = SmartLoginFactory.build(LoginType.Facebook);
                    } else if(currentUser instanceof SmartGoogleUser) {
                        smartLogin = SmartLoginFactory.build(LoginType.Google);
                    } else {
                        smartLogin = SmartLoginFactory.build(LoginType.CustomLogin);
                    }
                    boolean result = smartLogin.logout(MainActivity.this);
                    if (result) {
                        refreshLayout();
                        Toast.makeText(MainActivity.this, "User logged out successfully", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Click(v);

            }

        });
        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Click(v);

            }
        });
        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Click(v);

            }
        });
        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Click(v);

            }
        });
        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Click(v);

            }
        });
        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Click(v);

            }
        });
        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Click(v);

            }
        });
        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Click(v);

            }
        });
        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Click(v);

            }
        });
        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Click(v);

            }
        });

        plus_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Click(v);

            }
        });
        subtract_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Click(v);

            }
        });
        multiply_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Click(v);

            }
        });
        divide_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Click(v);

            }
        });
        equal_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Click(v);

            }
        });
        sin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Click(v);

            }
        });
        tan_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Click(v);

            }
        });
        cos_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Click(v);

            }
        });

        dot_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Click(v);

            }
        });
        percent_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Click(v);

            }
        });
        delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Click(v);

            }
        });
        ac_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Click(v);

            }
        });
    }

    private void bindViews() {
        facebookLoginButton = (Button) findViewById(R.id.facebook_login_button);
        googleLoginButton = (Button) findViewById(R.id.google_login_button);
        customSigninButton = (Button) findViewById(R.id.custom_signin_button);
        customSignupButton = (Button) findViewById(R.id.custom_signup_button);
        emailEditText = (EditText) findViewById(R.id.email_edittext);
        passwordEditText = (EditText) findViewById(R.id.password_edittext);
        logoutButton = (Button) findViewById(R.id.logout_button);
        calculatorRes= (EditText) findViewById(R.id.result_text);
        calculator= (RelativeLayout) findViewById(R.id.calculator_layout);
        num0 = (Button) findViewById(R.id.num_zero);
        num1 = (Button) findViewById(R.id.num_one);
        num2 = (Button) findViewById(R.id.num_two);
        num3 = (Button) findViewById(R.id.num_three);
        num4 = (Button) findViewById(R.id.num_four);
        num5 = (Button) findViewById(R.id.num_five);
        num6 = (Button) findViewById(R.id.num_six);
        num7 = (Button) findViewById(R.id.num_seven);
        num8 = (Button) findViewById(R.id.num_eight);
        num9 = (Button) findViewById(R.id.num_nine);

        plus_btn = (Button) findViewById(R.id.plus_btn);
        subtract_btn = (Button) findViewById(R.id.subtract_btn);
        multiply_btn = (Button) findViewById(R.id.multiply_btn);
        divide_btn = (Button) findViewById(R.id.divide_btn);
        equal_btn = (Button) findViewById(R.id.equal_btn);


        dot_btn = (Button) findViewById(R.id.dot_btn);
        percent_btn = (Button) findViewById(R.id.percent_btn);
        delete_btn = (Button) findViewById(R.id.delete_btn);
        ac_btn = (Button) findViewById(R.id.ac_btn);

        sin_btn = (Button) findViewById(R.id.sin_btn);
        cos_btn = (Button) findViewById(R.id.cos_btn);
        tan_btn = (Button) findViewById(R.id.tan_btn);


        mResultText = (EditText) findViewById(R.id.result_text);

        existedText = mResultText.getText().toString();

    }

    @Override
    public void onLoginSuccess(SmartUser user) {
        Toast.makeText(this, user.toString(), Toast.LENGTH_SHORT).show();
        refreshLayout();
    }

    @Override
    public void onLoginFailure(SmartLoginException e) {
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public SmartUser doCustomLogin() {
        SmartUser user = new SmartUser();
        user.setEmail(emailEditText.getText().toString());
        return user;
    }

    @Override
    public SmartUser doCustomSignup() {
        SmartUser user = new SmartUser();
        user.setEmail(emailEditText.getText().toString());
        return user;
    }

    @Override
    public void onClick(View v) {

    }


    public void Click(View v) {

        switch (v.getId()){

            case R.id.num_zero:
                existedText = isOverRange(existedText,"0");
                break;
            case R.id.num_one:
                existedText = isOverRange(existedText,"1");
                break;
            case R.id.num_two:
                existedText = isOverRange(existedText,"2");
                break;
            case R.id.num_three:
                existedText = isOverRange(existedText,"3");
                break;
            case R.id.num_four:
                existedText = isOverRange(existedText,"4");
                break;
            case R.id.num_five:
                existedText = isOverRange(existedText,"5");
                break;
            case R.id.num_six:
                existedText = isOverRange(existedText,"6");
                break;
            case R.id.num_seven:
                existedText = isOverRange(existedText,"7");
                break;
            case R.id.num_eight:
                existedText = isOverRange(existedText,"8");
                break;
            case R.id.num_nine:
                existedText = isOverRange(existedText,"9");
                break;

            case R.id.plus_btn:

                if (!existedText.contains("e")) {

                    if (judgeExpression()) {
                        existedText = getResult();
                        if (existedText.equals("error")){

                        } else {
                            existedText += "+";
                        }
                    } else {

                        if (isCounted) {
                            isCounted = false;
                        }

                        if ((existedText.substring(existedText.length() - 1)).equals("-")) {
                            existedText = existedText.replace("-", "+");
                        } else if ((existedText.substring(existedText.length() - 1)).equals("×")) {
                            existedText = existedText.replace("×", "+");
                        } else if ((existedText.substring(existedText.length() - 1)).equals("÷")) {
                            existedText = existedText.replace("÷", "+");
                        } else if (!(existedText.substring(existedText.length() - 1)).equals("+")) {
                            existedText += "+";
                        }
                    }
                } else {
                    existedText = "0";
                }

                break;
            case R.id.subtract_btn:

                if (!existedText.contains("e")) {
                    if (judgeExpression()) {
                        existedText = getResult();
                        if (existedText.equals("error")){

                        } else {
                            existedText += "-";
                        }
                    } else {

                        if (isCounted) {
                            isCounted = false;
                        }

                        if ((existedText.substring(existedText.length() - 1)).equals("+")) {
//                    Log.d("Anonymous", "onClick: " + "进入减法方法");
                            existedText = existedText.replace("+", "-");
                        } else if ((existedText.substring(existedText.length() - 1)).equals("×")) {
                            existedText = existedText.replace("×", "-");
                        } else if ((existedText.substring(existedText.length() - 1)).equals("÷")) {
                            existedText = existedText.replace("÷", "-");
                        } else if (!(existedText.substring(existedText.length() - 1)).equals("-")) {
                            existedText += "-";
                        }
                    }
                } else {
                    existedText = "0";
                }
                break;
            case R.id.multiply_btn:

                if (!existedText.contains("e")) {
                    if (judgeExpression()) {
                        existedText = getResult();
                        if (existedText.equals("error")){

                        } else {
                            existedText += "×";
                        }

                    } else {

                        if (isCounted) {
                            isCounted = false;
                        }

                        if ((existedText.substring(existedText.length() - 1)).equals("+")) {
                            existedText = existedText.replace("+", "×");
                        } else if ((existedText.substring(existedText.length() - 1)).equals("-")) {
                            existedText = existedText.replace("-", "×");
                        } else if ((existedText.substring(existedText.length() - 1)).equals("÷")) {
                            existedText = existedText.replace("÷", "×");
                        } else if (!(existedText.substring(existedText.length() - 1)).equals("×")) {
                            existedText += "×";
                        }
                    }
                } else {
                    existedText = "0";
                }
                break;
            case R.id.divide_btn:

                if (!existedText.contains("e")) {
                    if (judgeExpression()) {
                        existedText = getResult();
                        if (existedText.equals("error")){

                        } else {
                            existedText += "÷";
                        }

                    } else {

                        if (isCounted) {
                            isCounted = false;
                        }

                        if ((existedText.substring(existedText.length() - 1)).equals("+")) {
                            existedText = existedText.replace("+", "÷");
                        } else if ((existedText.substring(existedText.length() - 1)).equals("-")) {
                            existedText = existedText.replace("-", "÷");
                        } else if ((existedText.substring(existedText.length() - 1)).equals("×")) {
                            existedText = existedText.replace("×", "÷");
                        } else if (!(existedText.substring(existedText.length() - 1)).equals("÷")) {
                            existedText += "÷";
                        }
                    }
                } else {
                    existedText = "0";
                }
                break;
            case R.id.equal_btn:

//                existedText=String.valueOf(Math.sin(getResult2()/180f*Math.PI));
                existedText=getResult();
                isCounted = true;
                break;

            case R.id.sin_btn:

                existedText=String.valueOf(Math.round(100*Math.sin(getResult2()/180f*Math.PI))/100f);
                isCounted = true;
                break;

            case R.id.cos_btn:

                existedText=String.valueOf(Math.round(100*Math.cos(getResult2()/180f*Math.PI))/100f);
                isCounted = true;
                break;

            case R.id.tan_btn:

                existedText=String.valueOf(Math.round(100*Math.tan(getResult2()/180f*Math.PI))/100f);
                isCounted = true;
                break;

            case R.id.dot_btn:

                if (!isCounted){

                    if (existedText.contains("+") || existedText.contains("-") ||
                            existedText.contains("×") || existedText.contains("÷") ){

                        String param1 = null;
                        String param2 = null;

                        if (existedText.contains("+")) {
                            param1 = existedText.substring(0, existedText.indexOf("+"));
                            param2 = existedText.substring(existedText.indexOf("+") + 1);
                        } else if (existedText.contains("-")) {
                            param1 = existedText.substring(0, existedText.indexOf("-"));
                            param2 = existedText.substring(existedText.indexOf("-") + 1);
                        } else if (existedText.contains("×")) {
                            param1 = existedText.substring(0, existedText.indexOf("×"));
                            param2 = existedText.substring(existedText.indexOf("×") + 1);
                        } else if (existedText.contains("÷")) {
                            param1 = existedText.substring(0, existedText.indexOf("÷"));
                            param2 = existedText.substring(existedText.indexOf("÷") + 1);
                        }
                        Log.d("Anonymous param1",param1);
                        Log.d("Anonymous param2",param2);

                        boolean isContainedDot = param2.contains(".");
                        if (param2.length() >= 9){

                        } else if (!isContainedDot){
                            if (param2.equals("")){
                                existedText += "0.";
                            } else {
                                existedText += ".";
                            }
                        } else {
                            return;
                        }
                    } else {
                        boolean isContainedDot = existedText.contains(".");
                        if (existedText.length() >= 9){

                        } else if (!isContainedDot){
                            existedText += ".";
                        } else {
                            return;
                        }
                    }
                    isCounted = false;

                } else {
                    existedText = "0.";
                    isCounted = false;
                }


                break;
            case R.id.percent_btn:

                if (existedText.equals("error")){

                } else {

                    getCondition();

                    if (startWithOperator || startWithSubtract || noStartWithOperator) {

                    } else {
                        if (existedText.equals("0")) {
                            return;
                        } else {
                            double temp = Double.parseDouble(existedText);
                            temp = temp / 100;
                            existedText = String.valueOf(temp);
                        }
                    }
                }
                break;
            case R.id.delete_btn:

                if (existedText.equals("error")){
                    existedText = "0";
                } else if (existedText.length() > 0){
                    if (existedText.length() == 1) {
                        existedText = "0";
                    } else {
                        existedText = existedText.substring(0,existedText.length()-1);
                    }
                }
                break;
            case R.id.ac_btn:
                existedText = "0";
                break;
        }


        mResultText.setText(existedText);
    }



    private String getResult() {


        String tempResult = null;

        String param1 = null;
        String param2 = null;

        double arg1 = 0;
        double arg2 = 0;
        double result = 0;

        getCondition();

        if ( startWithOperator || noStartWithOperator || startWithSubtract) {

            if (existedText.contains("+")) {

                param1 = existedText.substring(0, existedText.indexOf("+"));
                param2 = existedText.substring(existedText.indexOf("+") + 1);

                if (param2.equals("")){
                    tempResult = existedText;
                } else {

                    arg1 = Double.parseDouble(param1);
                    arg2 = Double.parseDouble(param2);
                    result = arg1 + arg2;
                    tempResult = String.format("%f", result);
                    tempResult = subZeroAndDot(tempResult);
                }


            } else if (existedText.contains("×")) {

                param1 = existedText.substring(0, existedText.indexOf("×"));
                param2 = existedText.substring(existedText.indexOf("×") + 1);

                if (param2.equals("")){
                    tempResult = existedText;
                } else {
                    arg1 = Double.parseDouble(param1);
                    arg2 = Double.parseDouble(param2);
                    result = arg1 * arg2;
                    tempResult = String.format("%f", result);
                    tempResult = subZeroAndDot(tempResult);
                }

            } else if (existedText.contains("÷")) {

                param1 = existedText.substring(0, existedText.indexOf("÷"));
                param2 = existedText.substring(existedText.indexOf("÷") + 1);

                if (param2.equals("0")){
                    tempResult = "error";
                } else if (param2.equals("")){
                    tempResult = existedText;
                } else {
                    arg1 = Double.parseDouble(param1);
                    arg2 = Double.parseDouble(param2);
                    result = arg1 / arg2;
                    tempResult = String.format("%f", result);
                    tempResult = subZeroAndDot(tempResult);
                }

            } else if (existedText.contains("-")) {


                param1 = existedText.substring(0, existedText.lastIndexOf("-"));
                param2 = existedText.substring(existedText.lastIndexOf("-") + 1);

                if (param2.equals("")){
                    tempResult = existedText;
                } else {
                    arg1 = Double.parseDouble(param1);
                    arg2 = Double.parseDouble(param2);
                    result = arg1 - arg2;
                    tempResult = String.format("%f", result);
                    tempResult = subZeroAndDot(tempResult);
                }

            }

            if (tempResult.length() >= 10) {
                tempResult = String.format("%e", Double.parseDouble(tempResult));
            } else if (tempResult.contains(".")) {
                if (tempResult.substring(0, tempResult.indexOf(".")).length() >= 10) {
                    tempResult = String.format("%e", Double.parseDouble(tempResult));
                }
            }
        } else {
            tempResult = existedText;
        }

        return tempResult;
    }

    private double getResult2() {

        String tempResult = null;
        String param1 = null;
        String param2 = null;
        double arg1 = 0;
        double arg2 = 0;
        double result = 0;
        getCondition();
        if ( startWithOperator || noStartWithOperator || startWithSubtract) {

            if (existedText.contains("+")) {

                param1 = existedText.substring(0, existedText.indexOf("+"));
                param2 = existedText.substring(existedText.indexOf("+") + 1);

                if (param2.equals("")){
                    result=Double.parseDouble(existedText);
//                    tempResult = existedText;
                } else {

                    arg1 = Double.parseDouble(param1);
                    arg2 = Double.parseDouble(param2);
                    result = arg1 + arg2;
//                    tempResult = String.format("%f", result);
//                    tempResult = subZeroAndDot(tempResult);
                }


            } else if (existedText.contains("×")) {

                param1 = existedText.substring(0, existedText.indexOf("×"));
                param2 = existedText.substring(existedText.indexOf("×") + 1);

                if (param2.equals("")){
//                    tempResult = existedText;
                    result=Double.parseDouble(existedText);
                } else {
                    arg1 = Double.parseDouble(param1);
                    arg2 = Double.parseDouble(param2);
                    result = arg1 * arg2;
                    tempResult = String.format("%f", result);
                    tempResult = subZeroAndDot(tempResult);
                }

            } else if (existedText.contains("÷")) {

                param1 = existedText.substring(0, existedText.indexOf("÷"));
                param2 = existedText.substring(existedText.indexOf("÷") + 1);

                if (param2.equals("0")){
                    tempResult = "error";
                } else if (param2.equals("")){
//                    tempResult = existedText;
                    result=Double.parseDouble(existedText);
                } else {
                    arg1 = Double.parseDouble(param1);
                    arg2 = Double.parseDouble(param2);
                    result = arg1 / arg2;
                    tempResult = String.format("%f", result);
                    tempResult = subZeroAndDot(tempResult);
                }

            } else if (existedText.contains("-")) {

                param1 = existedText.substring(0, existedText.lastIndexOf("-"));
                param2 = existedText.substring(existedText.lastIndexOf("-") + 1);

                if (param2.equals("")){
//                    tempResult = existedText;
                    result=Double.parseDouble(existedText);
                } else {
                    arg1 = Double.parseDouble(param1);
                    arg2 = Double.parseDouble(param2);
                    result = arg1 - arg2;
//                    tempResult = String.format("%f", result);
//                    tempResult = subZeroAndDot(tempResult);
                }

            }

        }
        else
        {
            result=Double.parseDouble(existedText);
        }
        return result;
    }


    private String isOverRange(String existedText, String s) {

        if (!isCounted){

            if (existedText.contains("e")){
                existedText = "0";
            }

            if (existedText.equals("0")){
                existedText = "";
            }

            if (existedText.contains("+") || existedText.contains("-") ||
                    existedText.contains("×") || existedText.contains("÷")){

                String param2 = null;
                if (existedText.contains("+")){
                    param2 = existedText.substring(existedText.indexOf("+")+1);
                } else if (existedText.contains("-")){
                    param2 = existedText.substring(existedText.indexOf("-")+1);
                } else if (existedText.contains("×")){
                    param2 = existedText.substring(existedText.indexOf("×")+1);
                } else if (existedText.contains("÷")){
                    param2 = existedText.substring(existedText.indexOf("÷")+1);
                }


                if (existedText.substring(existedText.length()-1).equals("+") ||
                        existedText.substring(existedText.length()-1).equals("-") ||
                        existedText.substring(existedText.length()-1).equals("×") ||
                        existedText.substring(existedText.length()-1).equals("÷")){
                    existedText += s;
                } else {
                    if (param2.contains(".")){
                        if (param2.length() >= 10){

                        } else {
                            existedText += s;
                        }
                    } else {
                        if (param2.length() >= 9){

                        } else {
                            existedText += s;
                        }
                    }
                }
            } else {

                if (existedText.contains(".")){
                    if (existedText.length() >= 10){

                    } else {
                        existedText += s;
                    }
                } else {
                    if (existedText.length() >= 9){

                    } else {
                        existedText += s;
                    }
                }
            }

            isCounted = false;

        } else {

            existedText = s;
            isCounted = false;

        }


        return existedText;
    }

    public static String subZeroAndDot(String s){
        if(s.indexOf(".") > 0){
            s = s.replaceAll("0+?$", "");//去掉多余的0
            s = s.replaceAll("[.]$", "");//如最后一位是.则去掉
        }
        return s;
    }

    private boolean judgeExpression() {

        getCondition();

        String tempParam2 = null;

        if ( startWithOperator || noStartWithOperator || startWithSubtract) {

            if (existedText.contains("+")) {

                tempParam2 = existedText.substring(existedText.indexOf("+") + 1);

                if (tempParam2.equals("")) {
                    return false;
                } else {
                    return true;
                }
            } else if (existedText.contains("×")) {

                tempParam2 = existedText.substring(existedText.indexOf("×") + 1);

                if (tempParam2.equals("")) {
                    return false;
                } else {
                    return true;
                }

            } else if (existedText.contains("÷")) {

                tempParam2 = existedText.substring(existedText.indexOf("÷") + 1);

                if (tempParam2.equals("")) {
                    return false;
                } else {
                    return true;
                }

            } else if (existedText.contains("-")) {


                tempParam2 = existedText.substring(existedText.lastIndexOf("-") + 1);

                if (tempParam2.equals("")) {
                    return false;
                } else {
                    return true;
                }

            }
        }
        return false;
    }


    private void getCondition() {
        startWithOperator = existedText.startsWith("-") && ( existedText.contains("+") ||
                existedText.contains("×") || existedText.contains("÷") );

        startWithSubtract = existedText.startsWith("-") && ( existedText.lastIndexOf("-") != 0 );

        noStartWithOperator = !existedText.startsWith("-") && ( existedText.contains("+") ||
                existedText.contains("-") || existedText.contains("×") || existedText.contains("÷"));
    }
}
