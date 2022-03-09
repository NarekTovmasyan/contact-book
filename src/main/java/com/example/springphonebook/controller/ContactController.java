package com.example.springphonebook.controller;

import com.example.springphonebook.model.Contact;
import com.example.springphonebook.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//ira mej sax crud@ ka avtomat bereluya
@RequestMapping("/api/v1/contact") //http://localhost:7070/api/v1/contact , ete mer 19 toxi @GetMapping-in tanq parametr contactic heto et el piti grvi postmanum menak
//request mapping@ incha, web.xml-na, uxutyunnerna te vor class piti gna mtni(postmani mej vor grenq es pakagceri mejin@ kberi stex)
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("get-all") //esi kara stanan parametr(@GetMapping("/get-all")) kara chstana, ete chenq talis prametr inq@ haskanuma get-all(getMappingi jamanak)
    ResponseEntity<List<Contact>> getAll() {//erb grum enq ResponseEntity<String> getAll(), nshanakuma vor inq@ veradardzneluya respons string tipi, u tak@ karanq grenq stringov ok-ic heto pakagceri mej, kam karanq grenq <Contact> tipi u ok-ic heto grenq new Contact()
        return ResponseEntity.ok(contactService.getAll());//erb verevi String type tanq Contact es "exav"-i tex@ karanq grenq new Contact(0,"Karen","Darbinyan","0942565","Work")
    }

    @GetMapping("/{key}")
    ResponseEntity<List<Contact>> getByKey(@PathVariable("key") String key) {
        return ResponseEntity.ok(contactService.getByKey(key));
    }

    @PostMapping//ete eli datark enq toxum gnuma add-a anum
    ResponseEntity<Contact> create(@RequestBody Contact contact) { //@RequestBody esi en postmani meji bodii mej vor grum einq dra hamara, u inq@ veradardznuma contact, dra hamar <Contact>
        return ResponseEntity.ok(contactService.create(contact));
    }

    @PutMapping("/{id}")//stexi id vor galisa inq@ mtnuma DB-um gtnuma et tablen, vor poxenq valuen
    ResponseEntity<Contact> update(@PathVariable("id") int id, @RequestBody Contact contact){//stex inq@ erku arjeqa stanum id ev value, id-in kpnum enq vercnum enq valuener@ u poxum enq vren: stexi ("id") hxvuma verevi toxi ay es "/{id}"-in
        return ResponseEntity.ok(contactService.update(contact,id));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable("id") int id){
        contactService.delete(id);
        return ResponseEntity.ok().build();
    }
}
