package com.eazySchool.demo.service;

import com.eazySchool.demo.constants.EazySchoolConstants;
import com.eazySchool.demo.controller.ContactController;
import com.eazySchool.demo.model.Contact;
import com.eazySchool.demo.repository.ContactRepository;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j // this lombok annotation automatically generated log object based upon the class name
@Service
public class ContactService {
//    private static Logger log =  LoggerFactory.getLogger(ContactService.class);
    @Autowired
    private ContactRepository contactRepository;
    public boolean saveMessageDetails(Contact contact){
        boolean isSaved = false;
//        log.info(contact.toString());
        contact.setStatus(EazySchoolConstants.OPEN);
        Contact savedContact = contactRepository.save(contact);
        if(savedContact != null && savedContact.getContactId()>0) {
            isSaved = true;
        }
        return isSaved;
    }

    public List<Contact> findAllMsgs(){
        Iterable<Contact> list1 = contactRepository.findAll();
        List<Contact> list = new ArrayList<>();

        // Iterate over the iterable and add each element to the list
        for (Contact contact : list1) {
            list.add(contact);
        }
        return list;
    }

    public List<Contact> findOpenStatusMsgs(){
        List<Contact> list = contactRepository.findByStatus(EazySchoolConstants.OPEN);
        return list;
    }
    public Page<Contact> findMsgsWithOpenStatus(int pageNum, String sortField, String sortDir){
        int pageSize = 5;
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize,
                sortDir.equals("asc") ? Sort.by(sortField).ascending()
                        : Sort.by(sortField).descending());
        Page<Contact> msgPage = contactRepository.findByStatus(
                EazySchoolConstants.OPEN,pageable);
        return msgPage;
    }
    public boolean updateMsgStatus1(int id){
        boolean isUpdated = false;
        Optional<Contact> contact = contactRepository.findById(id);
        contact.ifPresent(contact1 -> {
            contact1.setStatus(EazySchoolConstants.CLOSE);
        });
        Contact updatedContact = contactRepository.save(contact.get());
        if(null != updatedContact && updatedContact.getUpdatedBy()!=null) {
            isUpdated = true;
        }
        return isUpdated;
    }

    public boolean updateMsgStatus(int contactId){
        boolean isUpdated = false;
        int rows = contactRepository.updateStatusById(EazySchoolConstants.CLOSE,contactId);
        if(rows > 0) {
            isUpdated = true;
        }
        return isUpdated;
    }

}
