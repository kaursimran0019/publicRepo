package org.dt.perf.adapter.persistenance;

import org.dt.perf.adapter.entity.MetaData;
import org.dt.perf.adapter.repository.MetaDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class MetaDataJpaAdapter{

    @Autowired
    private MetaDataRepository metaDataRepository;
//    @Transactional
    public boolean addToMetaData(MetaData metaData)
    {
        try {
            metaDataRepository.save(metaData);
            return true;
        }
        catch (Exception e)
        {
            System.out.println(e);
            return false;
        }
    }

    public Object getAllMetaData()
    {
        try
        {
            return metaDataRepository.findAll();
        }
        catch (Exception e)
        {
            System.out.println(e);
            return "REPO FINDALL NOT WORKING";
        }
    }

    public boolean updateMetaData()
    {
        return  true;
    }

    public Optional<MetaData> findById(int id)
    {
        return metaDataRepository.findById(id);
    }
}
