package com.zenika.training.bc_intervention.infrastructure.postgres.intervention;

import java.util.Optional;

import com.zenika.training.bc_intervention.domain.intervention.InterventionRepository;
import com.zenika.training.bc_intervention.domain.intervention.exceptions.PostalCodeException;
import com.zenika.training.bc_intervention.domain.intervention.models.Intervention;
import com.zenika.training.bc_intervention.domain.intervention.models.InterventionId;

public class PgInterventionRepository implements InterventionRepository {

    private InterventionDao interventionDao;
    private InterventionMapper mapper;

    public PgInterventionRepository(InterventionDao interventionDao, InterventionMapper mapper) {
        this.interventionDao = interventionDao;
        this.mapper = mapper;
    }

    @Override
    public void saveIntervention(Intervention intervention) {
        InterventionEntity e = this.interventionDao.save(mapper.fromDomain(intervention));

    }

    @Override
    public Intervention getInterventionBy(InterventionId id) throws PostalCodeException {


        Optional<InterventionEntity> e = interventionDao.findById(id.id);


        if(e.isPresent()){
            return mapper.toDomain(e.get());
        }

        return null;



    }
    
}
