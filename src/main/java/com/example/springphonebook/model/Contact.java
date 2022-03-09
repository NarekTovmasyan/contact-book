package com.example.springphonebook.model;

import com.example.springphonebook.model.util.Label;
import lombok.Data;
import lombok.ToString;
import javax.persistence.*;

@Data //geter seter sarqelu hamara
@ToString //esi mez ognec posti jamanak
@Entity //esi ogneluya vor kpnenq DB-in, bayc dra hamar mez naev ID e petq, vor@ grum enq 13toxum
//OAM-object related mapping, inq@ DB-i het object@ haylayin sarquma, u inq@ mer resursi mej grac DB-i hasceov gnuma u sarquma tablener@
public class Contact {
    @Id //esi piti partadir lini javax.persistence
    @GeneratedValue //@GeneratedValue(strategy=GenerationType.AUTO) id-n talis enq @GeneratedValue, vor@ eli vercnum enq javax.persistence-ic(sa el ira hertin galisa pom.xml-i mejic jpa-ic(java persistance API)
   //u erb talis enq Auto inq@ avtomat voroshuma increment ani kam urish tenc baner, esi amenaharmar tarberakna
    private int id;//14 toxi ID-ov asecinq vor mer 17toxi id-n tox DB-i idn lini u generacuma lini avtomat(inq@ voroshvi auto) 15 toxi anotaciayov(increment, not null, unique, primary key, esi en ptichkeqna DB-um vor dnum enq)

    //@Column(name = "Petros"), erb vor mer namei vra senc ban kaxenq, inq@ mer DB-um sarqvox tox@ kpahi voch te name-ov ayl petrosov,qani vor mer resursi mej tvaca es (spring.jpa.hibernate.ddl-auto=update)u inq@ avtomat tarmacrec u esi stringneri hamara
    private String name;

    private String surname;

    private String phone;

    @Enumerated(EnumType.STRING)//esi hashvelia kochvum(tvarkvac), eti mer Labeli meja, hima asuma es et tvarkvac@ vercnem stringov te ordinal, mer depqum stringa petq vor anun@ vercni(personal, work ev home), ordinali jamanak hamarna vercnelu indexi nman motavor
    private Label phoneLabel; //erb Label grum enq cragir@ beruma mi qani hat, piti @ntrenq mer@ papkeqov galisa utili meji Labeli mot

    @Column(nullable=false)//@NotNull karanq esi kaxenq vren u asenq vor inq@ null chi kara lini(dependensium petqa avelacnenq) kam @Column(nullable=false)(default-ov kara null lini erb true havasar) bayc menq asum enq false vor null chlini
    private String email;

    @Enumerated(EnumType.STRING)
    private Label emailLabel;

    public String stringify() {
        return "" + name +
                "" + surname +
                "" + phone +
                "" + phoneLabel +
                "" + email +
                "" + emailLabel;
    }
}
