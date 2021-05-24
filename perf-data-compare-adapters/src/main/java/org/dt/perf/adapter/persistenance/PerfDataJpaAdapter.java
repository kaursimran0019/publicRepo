package org.dt.perf.adapter.persistenance;

import org.dt.perf.adapter.entity.PerfData;
import org.dt.perf.adapter.mappers.PerfDataMapper;
import org.dt.perf.adapter.repository.PerfDataRepository;
import org.dt.perf.api.request.PerfInputRequest;
import org.dt.perf.api.response.PerfDataResponse;
import org.dt.perf.core.port.out.DataComparePersistenancePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

@Service
public class PerfDataJpaAdapter implements DataComparePersistenancePort {

    PerfDataMapper perfDataMapper;
    @Autowired
    private PerfDataRepository perfDataRepository;

    @Override
    public Object getAllPerf()
    {
        return perfDataRepository.findAll();
    }

    @Override
    public Object findById(Integer id)
    {
        return perfDataRepository.findById(id);
    }

    @Override
    public List<org.dt.perf.api.model.PerfData> findByMetaId(Integer id)
    {
        Vector<org.dt.perf.api.model.PerfData> v = new Vector<org.dt.perf.api.model.PerfData>();
        List<org.dt.perf.api.model.PerfData> ret = perfDataRepository.findByMetaId(id);
//        for(PerfData P: o)
//        {
//            if(P.getMetaId()==id) v.add(perfDataMapper.perfToPerfDto(P));
//        }
        return ret;
    }
    private Integer getVal(int i,int j)
    {
        if(i>j) return 1;
        if(i<j) return -1;
        return 0;
    }

    @Override
    public PerfDataResponse getComparisonData(PerfInputRequest R)
    {
        Integer M1 = Integer.parseInt(R.getPerfId1());
        Integer M2 = Integer.parseInt(R.getPerfId2());
        List<String> li = R.getApiList();
        HashMap<String, Map<String, Integer>> mp = new HashMap<String, Map<String, Integer>>();
        List<org.dt.perf.api.model.PerfData> li1 = findByMetaId(M1);
        List<org.dt.perf.api.model.PerfData> li2 = findByMetaId(M2);
         for(org.dt.perf.api.model.PerfData k: li1)
         {
             for (org.dt.perf.api.model.PerfData l: li2)
             {
                 PerfData ap1 = perfDataMapper.perfDtoToPerf(k);
                 PerfData ap2 = perfDataMapper.perfDtoToPerf(l);
                 if(ap1.getName().compareTo(ap2.getName())==0&&li.contains(ap1.getName()))
                 {
                     System.out.println("HAPPENS");
                     HashMap<String, Integer> mp2 = new HashMap<String,Integer>();

                     mp2.put("maxTime",getVal(ap1.getMaxResp(),ap2.getMaxResp()));
                     mp2.put("avgTime",getVal(ap1.getAvgResp(),ap2.getAvgResp()));
                     mp2.put("minTime",getVal(ap1.getMinResp(),ap2.getMinResp()));

                     mp.put(ap1.getName(),mp2);
                 }
             }
         }

         PerfDataResponse ret= new PerfDataResponse("COOL",mp);
         return ret;
    }
}
