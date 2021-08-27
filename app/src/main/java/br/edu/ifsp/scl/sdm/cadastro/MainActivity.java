package br.edu.ifsp.scl.sdm.cadastro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import br.edu.ifsp.scl.sdm.cadastro.model.Formulario;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextInputLayout mNomeTextInputLayout;
    private TextInputLayout mTelefoneTextInputLayout;
    private TextInputLayout mEmailTextInputLayout;
    private CheckBox mIngressarListaEmailCb;
    private RadioButton mFRadioButton;
    private RadioButton mMRadioButton;
    private TextInputLayout mCidadeTextInputLayout;
    private Spinner mUfSpinner;
    private Button mSalvarButton;
    private Button mLimparButton;
    private Formulario mForm;

    private final static String EXTRA_FORM = "extra_form";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null){
            mForm = savedInstanceState.getParcelable(EXTRA_FORM);
        }

        bindViews();


    }

    private void bindViews(){

        mNomeTextInputLayout = findViewById(R.id.nomeTextInputLayout);
        mTelefoneTextInputLayout = findViewById(R.id.telefoneTextInputLayout);
        mEmailTextInputLayout = findViewById(R.id.emailTextInputLayout);
        mIngressarListaEmailCb = findViewById(R.id.ingressarLECheckBox);
        mFRadioButton = findViewById(R.id.fRadioButton);
        mMRadioButton = findViewById(R.id.mRadioButton);
        mCidadeTextInputLayout = findViewById(R.id.cidadeTextInputLayout);
        mUfSpinner = findViewById(R.id.ufSpinner);
        mSalvarButton = findViewById(R.id.buttonSalvar);
        mLimparButton = findViewById(R.id.buttonLimpar);

        mSalvarButton.setOnClickListener(this);
        mLimparButton.setOnClickListener(this);


    }

    private void createForm(){

        mForm = new Formulario();

        if (mNomeTextInputLayout != null && isNotEmptyOrNull(mNomeTextInputLayout.getEditText())){
            mForm.setNome(mNomeTextInputLayout.getEditText().getText().toString());
        }
        if (mTelefoneTextInputLayout != null && isNotEmptyOrNull(mTelefoneTextInputLayout.getEditText())){
            mForm.setTelefone(mTelefoneTextInputLayout.getEditText().getText().toString());
        }
        if (mEmailTextInputLayout != null && isNotEmptyOrNull(mEmailTextInputLayout.getEditText())){
            mForm.setEmail(mEmailTextInputLayout.getEditText().getText().toString());
        }
        if (mIngressarListaEmailCb != null){
            mForm.setInListaEmail(mIngressarListaEmailCb.isChecked());
        }
        if (mFRadioButton != null){
            if (mFRadioButton.isChecked()){
                mForm.setSexo("F");
            }
        }
        if (mMRadioButton != null){
            if (mMRadioButton.isChecked()){
                mForm.setSexo("M");
            }
        }
        if (mCidadeTextInputLayout != null && isNotEmptyOrNull(mCidadeTextInputLayout.getEditText())){
            mForm.setCidade(mCidadeTextInputLayout.getEditText().getText().toString());
        }
        if (mUfSpinner != null){
            mForm.setUf(((TextView) mUfSpinner.getSelectedView()).getText().toString());
        }

    }

    private boolean isNotEmptyOrNull(EditText editText){

        return editText != null && editText.getText() != null && !editText.getText().toString().isEmpty();

    }

    private void showToast(){

        StringBuilder sb = new StringBuilder();
        sb.append("");
        if (mForm != null){

            sb.append(mForm.getNome() != null ? mForm.getNome().concat(" \n") : "");
            sb.append(mForm.getTelefone() != null ? mForm.getTelefone().concat(" \n") : "");
            sb.append(mForm.getEmail() != null ? mForm.getEmail().concat(" \n") : "");
            sb.append(mForm.getSexo() != null ? mForm.getSexo().concat(" \n") : "");
            sb.append(mForm.isInListaEmail()  ? "Está na lista de email." : "Não está na lista de email.");
            sb.append("\n");
            sb.append(mForm.getCidade() != null ?  mForm.getCidade().concat(" \n") : "");
            sb.append(mForm.getUf() != null ? mForm.getUf().concat(" \n") : "");
        }

        Toast.makeText(this, sb, Toast.LENGTH_SHORT).show();
    }

    private void clearViews(){

        if (mNomeTextInputLayout != null && isNotEmptyOrNull(mNomeTextInputLayout.getEditText())) mNomeTextInputLayout.getEditText().getText().clear();
        if (mTelefoneTextInputLayout != null && isNotEmptyOrNull(mTelefoneTextInputLayout.getEditText())) mTelefoneTextInputLayout.getEditText().getText().clear();
        if (mEmailTextInputLayout != null && isNotEmptyOrNull(mEmailTextInputLayout.getEditText())) mEmailTextInputLayout.getEditText().getText().clear();
        if (mIngressarListaEmailCb != null) mIngressarListaEmailCb.setChecked(false);
        if (mFRadioButton != null) mFRadioButton.setChecked(false);
        if (mMRadioButton != null) mMRadioButton.setChecked(false);
        if (mCidadeTextInputLayout != null && isNotEmptyOrNull(mCidadeTextInputLayout.getEditText())) mCidadeTextInputLayout.getEditText().getText().clear();
        if (mUfSpinner != null) mUfSpinner.setSelection(0);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.buttonSalvar:
                if (mForm == null) {
                    createForm();
                    showToast();
                }
                break;
            case R.id.buttonLimpar:
                if (mForm != null) mForm = null;
                clearViews();
                break;
        }

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        if (mForm != null){
            outState.putParcelable(EXTRA_FORM, mForm);
        }

    }
}