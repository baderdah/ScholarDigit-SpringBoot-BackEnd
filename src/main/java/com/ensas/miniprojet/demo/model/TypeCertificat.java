package com.ensas.miniprojet.demo.model;

public enum TypeCertificat {

    scholarity("scholarity"),
    success("success");

    private String typeCertificat;

    TypeCertificat(String typeCertificat) {
        this.typeCertificat = typeCertificat;
    }

    public String getTypeCertificat() {
        return typeCertificat;
    }
}