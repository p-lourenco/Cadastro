package br.edu.ifsp.scl.sdm.cadastro.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Formulario implements Parcelable {

    private String nome;
    private String telefone;
    private String email;
    private boolean inListaEmail;
    private String sexo;
    private String cidade;
    private String uf;


    public Formulario(){

    }
    protected Formulario(Parcel in) {
        nome = in.readString();
        telefone = in.readString();
        email = in.readString();
        inListaEmail = in.readByte() != 0;
        sexo = in.readString();
        cidade = in.readString();
        uf = in.readString();
    }

    public static final Creator<Formulario> CREATOR = new Creator<Formulario>() {
        @Override
        public Formulario createFromParcel(Parcel in) {
            return new Formulario(in);
        }

        @Override
        public Formulario[] newArray(int size) {
            return new Formulario[size];
        }
    };

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isInListaEmail() {
        return inListaEmail;
    }

    public void setInListaEmail(boolean inListaEmail) {
        this.inListaEmail = inListaEmail;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeString(telefone);
        dest.writeString(email);
        dest.writeByte((byte) (inListaEmail ? 1 : 0));
        dest.writeString(sexo);
        dest.writeString(cidade);
        dest.writeString(uf);
    }
}
