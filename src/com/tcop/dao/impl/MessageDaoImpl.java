package com.tcop.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.tcop.Page;
import com.tcop.Pageable;
import com.tcop.dao.MessageDao;
import com.tcop.entity.Member;
import com.tcop.entity.Message;

import org.springframework.stereotype.Repository;

@Repository("messageDaoImpl")
public class MessageDaoImpl
  extends BaseDaoImpl<Message, Long>
  implements MessageDao
{
  public Page<Message> findPage(Member member, Pageable pageable)
  {
    CriteriaBuilder localCriteriaBuilder = this.entityManager.getCriteriaBuilder();
    CriteriaQuery localCriteriaQuery = localCriteriaBuilder.createQuery(Message.class);
    Root localRoot = localCriteriaQuery.from(Message.class);
    localCriteriaQuery.select(localRoot);
    Predicate localPredicate = localCriteriaBuilder.conjunction();
    localPredicate = localCriteriaBuilder.and(new Predicate[] { localPredicate, localCriteriaBuilder.isNull(localRoot.get("forMessage")), localCriteriaBuilder.equal(localRoot.get("isDraft"), Boolean.valueOf(false)) });
    if (member != null) {
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.or(localCriteriaBuilder.and(localCriteriaBuilder.equal(localRoot.get("sender"), member), localCriteriaBuilder.equal(localRoot.get("senderDelete"), Boolean.valueOf(false))), localCriteriaBuilder.and(localCriteriaBuilder.equal(localRoot.get("receiver"), member), localCriteriaBuilder.equal(localRoot.get("receiverDelete"), Boolean.valueOf(false)))));
    } else {
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.or(localCriteriaBuilder.and(localCriteriaBuilder.isNull(localRoot.get("sender")), localCriteriaBuilder.equal(localRoot.get("senderDelete"), Boolean.valueOf(false))), localCriteriaBuilder.and(localCriteriaBuilder.isNull(localRoot.get("receiver")), localCriteriaBuilder.equal(localRoot.get("receiverDelete"), Boolean.valueOf(false)))));
    }
    localCriteriaQuery.where(localPredicate);
    return super.IIIllIlI(localCriteriaQuery, pageable);
  }
  
  public Page<Message> findDraftPage(Member sender, Pageable pageable)
  {
    CriteriaBuilder localCriteriaBuilder = this.entityManager.getCriteriaBuilder();
    CriteriaQuery localCriteriaQuery = localCriteriaBuilder.createQuery(Message.class);
    Root localRoot = localCriteriaQuery.from(Message.class);
    localCriteriaQuery.select(localRoot);
    Predicate localPredicate = localCriteriaBuilder.conjunction();
    localPredicate = localCriteriaBuilder.and(new Predicate[] { localPredicate, localCriteriaBuilder.isNull(localRoot.get("forMessage")), localCriteriaBuilder.equal(localRoot.get("isDraft"), Boolean.valueOf(true)) });
    if (sender != null) {
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.equal(localRoot.get("sender"), sender));
    } else {
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.isNull(localRoot.get("sender")));
    }
    localCriteriaQuery.where(localPredicate);
    return super.IIIllIlI(localCriteriaQuery, pageable);
  }
  
  public Long count(Member member, Boolean read)
  {
    CriteriaBuilder localCriteriaBuilder = this.entityManager.getCriteriaBuilder();
    CriteriaQuery localCriteriaQuery = localCriteriaBuilder.createQuery(Message.class);
    Root localRoot = localCriteriaQuery.from(Message.class);
    localCriteriaQuery.select(localRoot);
    Predicate localPredicate = localCriteriaBuilder.conjunction();
    localPredicate = localCriteriaBuilder.and(new Predicate[] { localPredicate, localCriteriaBuilder.isNull(localRoot.get("forMessage")), localCriteriaBuilder.equal(localRoot.get("isDraft"), Boolean.valueOf(false)) });
    if (member != null)
    {
      if (read != null) {
        localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.or(localCriteriaBuilder.and(new Predicate[] { localCriteriaBuilder.equal(localRoot.get("sender"), member), localCriteriaBuilder.equal(localRoot.get("senderDelete"), Boolean.valueOf(false)), localCriteriaBuilder.equal(localRoot.get("senderRead"), read) }), localCriteriaBuilder.and(new Predicate[] { localCriteriaBuilder.equal(localRoot.get("receiver"), member), localCriteriaBuilder.equal(localRoot.get("receiverDelete"), Boolean.valueOf(false)), localCriteriaBuilder.equal(localRoot.get("receiverRead"), read) })));
      } else {
        localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.or(localCriteriaBuilder.and(localCriteriaBuilder.equal(localRoot.get("sender"), member), localCriteriaBuilder.equal(localRoot.get("senderDelete"), Boolean.valueOf(false))), localCriteriaBuilder.and(localCriteriaBuilder.equal(localRoot.get("receiver"), member), localCriteriaBuilder.equal(localRoot.get("receiverDelete"), Boolean.valueOf(false)))));
      }
    }
    else if (read != null) {
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.or(localCriteriaBuilder.and(new Predicate[] { localCriteriaBuilder.isNull(localRoot.get("sender")), localCriteriaBuilder.equal(localRoot.get("senderDelete"), Boolean.valueOf(false)), localCriteriaBuilder.equal(localRoot.get("senderRead"), read) }), localCriteriaBuilder.and(new Predicate[] { localCriteriaBuilder.isNull(localRoot.get("receiver")), localCriteriaBuilder.equal(localRoot.get("receiverDelete"), Boolean.valueOf(false)), localCriteriaBuilder.equal(localRoot.get("receiverRead"), read) })));
    } else {
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.or(localCriteriaBuilder.and(localCriteriaBuilder.isNull(localRoot.get("sender")), localCriteriaBuilder.equal(localRoot.get("senderDelete"), Boolean.valueOf(false))), localCriteriaBuilder.and(localCriteriaBuilder.isNull(localRoot.get("receiver")), localCriteriaBuilder.equal(localRoot.get("receiverDelete"), Boolean.valueOf(false)))));
    }
    localCriteriaQuery.where(localPredicate);
    //��ʱ�޸ģ�������� wulinjie
    return super.IIIllIlI(localCriteriaQuery, (List)null);
  }
  
  public void remove(Long id, Member member)
  {
    Message localMessage = (Message)super.find(id);
    if ((localMessage == null) || (localMessage.getForMessage() != null)) {
      return;
    }
    if (member == localMessage.getReceiver())
    {
      if (!localMessage.getIsDraft().booleanValue()) {
        if (localMessage.getSenderDelete().booleanValue())
        {
          super.remove(localMessage);
        }
        else
        {
          localMessage.setReceiverDelete(Boolean.valueOf(true));
          super.merge(localMessage);
        }
      }
    }
    else if (member == localMessage.getSender()) {
      if (localMessage.getIsDraft().booleanValue())
      {
        super.remove(localMessage);
      }
      else if (localMessage.getReceiverDelete().booleanValue())
      {
        super.remove(localMessage);
      }
      else
      {
        localMessage.setSenderDelete(Boolean.valueOf(true));
        super.merge(localMessage);
      }
    }
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.dao.impl.MessageDaoImpl
 * JD-Core Version:    0.7.0.1
 */