package com.hdc.zs.art.serviceimpl;

import com.hdc.zs.art.dao.JournalismDao;
import com.hdc.zs.art.empty.Journalism;
import com.hdc.zs.art.service.JournalismService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("JournalismService")
public class JournalismServiceImpl implements JournalismService {
@Autowired
private JournalismDao journalismDao;
    @Override
    public List<Journalism> findNews() {
        return this.journalismDao.findNews();
    }

    @Override
    public int updateNews(Journalism journalism) {
        return this.journalismDao.updateNews(journalism);
    }
}
