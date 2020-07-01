package com.ensas.miniprojet.demo.service.CertifRequest;

import com.ensas.miniprojet.demo.entity.CertifRequest;
import com.ensas.miniprojet.demo.entity.Classe;

import java.util.List;

public interface CertifRequestService {
    List<CertifRequest> getCertifRequests();
    CertifRequest getCertifRequest(Long certifRequestId);
    CertifRequest addCertifRequest(CertifRequest certifRequest);
    void delCertifRequest(Long certifRequestId);
    CertifRequest updateCertifRequest(CertifRequest certifRequest);
}