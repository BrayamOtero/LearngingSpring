package com.example.holaspring.service;

import com.example.holaspring.dao.PersonaDao;
import com.example.holaspring.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//Sin esto, nose podria inyectar esta clase, como una implementacion de PersonaService dentro del cotrolador de spring
@Service
public class PersonaServiceImpl  implements PersonaService{

    @Autowired
    private PersonaDao personaDao;

    /*en la capa de servicio, se manejan concepto de transacciones
     * esto quiere decur que cual quier operacion con la sd y se produce un eeror se va hacer un rollback
     * o en el caso de que to-do sea exitoso se va hacer un commit.
     * Por lo tanto los siguientes funciones deben tener la etiqueta Transactional, por si algo falla no guardar nada en
     * la bd.
     * Dependiendo del tipo de metodo es el tipo de transaccion, por ejemplo en este solo se va a leer la bd no a modificar
     * por lo tanto se define de esa manera*/
    @Override
    @Transactional(readOnly = true)
    public List<Persona> listarPersonas() {
        return personaDao.findAll();
    }

    /*
    * PEro en los siguientes dos sí, porque se modifica la bd*/
    @Override
    @Transactional
    public void guardar(Persona persona) {
        personaDao.save(persona);
    }

    @Override
    @Transactional
    public void eliminar(Persona persona) {
        personaDao.delete(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona encontarPersona(Persona persona) {
        //orElse por si falla la consulta trae un null
        return personaDao.findById(persona.getIdPersona()).orElse(null);
    }
}
