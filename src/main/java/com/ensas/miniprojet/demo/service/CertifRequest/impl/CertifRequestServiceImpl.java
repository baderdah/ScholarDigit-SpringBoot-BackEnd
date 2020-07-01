package com.ensas.miniprojet.demo.service.CertifRequest.impl;

import com.ensas.miniprojet.demo.entity.CertifRequest;
import com.ensas.miniprojet.demo.repository.certifRequestRepository.CertifRequestRepository;
import com.ensas.miniprojet.demo.repository.filiereRepository.FiliereRepository;
import com.ensas.miniprojet.demo.service.CertifRequest.CertifRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class CertifRequestServiceImpl implements CertifRequestService {

    @Autowired
    CertifRequestRepository certifRequestRepository;

    @Override
    @Transactional
    public List<CertifRequest> getCertifRequests() {
        return certifRequestRepository.findAll();
    }

    @Override
    @Transactional
    public CertifRequest getCertifRequest(Long certifRequestId) {
        return certifRequestRepository.findById(certifRequestId).get();
    }

    @Override
    @Transactional
    public CertifRequest addCertifRequest(CertifRequest certifRequest) {
        return certifRequestRepository.save(certifRequest);
    }

    @Override
    @Transactional
    public void delCertifRequest(Long certifRequestId) {
        certifRequestRepository.deleteById(certifRequestId);
    }

    @Override
    @Transactional
    public CertifRequest updateCertifRequest(CertifRequest certifRequest) {
        return certifRequestRepository.save(certifRequest);
    }
}
