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

    @Autowired
    PerfDataMapper perfDataMapper;
    @Autowired
    private PerfDataRepository perfDataRepository;

    @Override
    public Object getAllPerf() {
        return perfDataRepository.findAll();
    }

    @Override
    public Object findById(Integer id) {
        return perfDataRepository.findById(id);
    }

    @Override
    public List<org.dt.perf.api.model.PerfData> findByMetaId(Integer id)
    {
//        return perfDataRepository.findByMetaId(id);
        System.out.println("Hello2");
        Vector<org.dt.perf.api.model.PerfData> v = new Vector<org.dt.perf.api.model.PerfData>();
//        List<org.dt.perf.api.model.PerfData> ret = perfDataRepository.findByMetaId(id);
        Iterable<PerfData> o = perfDataRepository.findAll();
        System.out.println(o);
        try
        {
            for (PerfData P : o) {
                if (P.getMetaId() == id) v.add(perfDataMapper.perfToPerfDto(P));
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
            return null;
        }
        return v;
    }
    private String getVal(int i,int j)
    {
        return String.valueOf(i-j)+" "+getRemark(i,j);
    }
    private String getRemark(int i, int j)
    {
        if(i < j)   return "Decrement";
        else if(i > j) return "Improvement";
        else return "Uniform";
    }

    @Override
    public PerfDataResponse getComparisonData(PerfInputRequest R)
    {
        Integer M1;
        Integer M2;
        try
        {
            M1 = Integer.parseInt(R.getPerfId1());
            M2 = Integer.parseInt(R.getPerfId2());
        }
        catch (Exception e)
        {
            PerfDataResponse p = new PerfDataResponse("PerfID Should be an Integer",null);
            return p;
        }
        List<String> li = R.getApiList();
        HashMap<String, Map<String, String>> mp = new HashMap<String, Map<String, String>>();
        List<org.dt.perf.api.model.PerfData> li1 = findByMetaId(M1);
        List<org.dt.perf.api.model.PerfData> li2 = findByMetaId(M2);
//        Query q = em.createNameQuery("PerfData.findByMetaId");
//        q.setParameter(M1, M2);
//        List<PerfData> a = q.getResultList();
        //System.out.println("Hello");
         for(org.dt.perf.api.model.PerfData k: li1)
         {
             for (org.dt.perf.api.model.PerfData l: li2)
             {
                 PerfData ap1 = perfDataMapper.perfDtoToPerf(k);
                 PerfData ap2 = perfDataMapper.perfDtoToPerf(l);
                 if(ap1.getName().compareTo(ap2.getName())==0&&(li.contains(ap1.getName()))||li.isEmpty())
                 {
                     //System.out.println("HAPPENS");
                     HashMap<String, String> mp2 = new HashMap<String,String>();

                     mp2.put("maxResponseTime",getVal(ap1.getMaxResp(),ap2.getMaxResp()));
                     mp2.put("avgResponseTime",getVal(ap1.getAvgResp(),ap2.getAvgResp()));
                     mp2.put("minResponseTime",getVal(ap1.getMinResp(),ap2.getMinResp()));
//                     mp2.put("maxTimeRemark",getRemark(ap1.getMaxResp(),ap2.getMaxResp()));
//                     mp2.put("minTimeRemark",getRemark(ap1.getMinResp(),ap2.getMinResp()));
//                     mp2.put("avgTimeRemark",getRemark(ap1.getAvgResp(),ap2.getAvgResp()));
                     mp.put(ap1.getName(),mp2);
                 }
             }
         }

         PerfDataResponse ret= new PerfDataResponse("Comparison Data",mp);
         return ret;
    }
}
