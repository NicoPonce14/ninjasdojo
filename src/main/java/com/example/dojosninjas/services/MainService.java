package com.example.dojosninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.dojosninjas.models.Dojo;
import com.example.dojosninjas.models.Ninja;
import com.example.dojosninjas.repositories.DojoRepo;
import com.example.dojosninjas.repositories.NinjaRepo;
import com.example.dojosninjas.repositories.NinjaRepoPage;

@Service
public class MainService {
    
    @Autowired
    private DojoRepo dojoRepo;

    @Autowired
    private NinjaRepo ninjaRepo;

    @Autowired
    private NinjaRepoPage ninjaRepoPage;

    //VARIABLE PARA DETERMINAR CUANTOS REGISTROS POR PAGINA
    private static final int PAGE_SIZE = 3;

    //crear un nuevo dojo
    public Dojo crearDojo(Dojo dojo){
        return dojoRepo.save(dojo);
    }

    public List<Dojo> todosDojo(){
        return dojoRepo.findAll();
    }

    public Dojo showDojo(Long id) {
		return dojoRepo.findById(id).orElse(null);
	}

    //crear un nuevo ninja
    public Ninja crearNinja(Ninja ninja){
        return ninjaRepo.save(ninja);
    }

    //METODOS PARA SEGMENTACION Y PAGINACION

    public Page<Ninja> ninjasPorPag(int numeroPag){
        PageRequest pageRequest = PageRequest.of(numeroPag,PAGE_SIZE,Sort.Direction.ASC, "dojo.name");
        return ninjaRepoPage.findAll(pageRequest);
    }

}
