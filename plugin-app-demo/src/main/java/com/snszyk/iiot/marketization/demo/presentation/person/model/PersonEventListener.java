package com.snszyk.iiot.marketization.demo.presentation.person.model;

import com.snszyk.iiot.marketization.demo.presentation.position.model.PositionQuery;
import com.snszyk.iiot.marketization.demo.presentation.position.model.PositionQueryModel;
import org.apache.commons.lang.StringUtils;
import org.jeecg.common.util.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
class UserEventListener implements ApplicationListener<UserEvent> {
    @Autowired
    private PersonQuery personQuery;
    @Autowired
    private PositionQuery positionQuery;

    @Override
    public void onApplicationEvent(UserEvent event) {
        UserModel target = event.getTarget();
        if (!(event.getSource() instanceof UserModel)) {
            // create event
            // PersonQueryModel person = PersonMapping.INSTANCES.user2Person(target);
//            person.setId(UUIDGenerator.generate());
//            Optional<PositionQueryModel> position = positionQuery.findById(target.getPositionId());
//            if (position.isPresent()) {
//                person.setPositionId(target.getPositionId());
//                person.setPositionName(position.get().getName());
//            }
//            personQuery.save(person);
        } else {
            UserModel source = (UserModel) event.getSource();
            if (target != null && StringUtils.equals(source.getId(), target.getId())) {
                PersonQueryModel person = personQuery.findById(source.getId()).get();
                if (!StringUtils.equals(source.getName(), target.getName())) {
                    person.setName(target.getName());
                }
                if (!StringUtils.equals(source.getPositionId(), target.getPositionId())) {
                    Optional<PositionQueryModel> position = positionQuery.findById(target.getPositionId());
                    if (position.isPresent()) {
                        person.setPositionId(target.getPositionId());
                        person.setPositionName(position.get().getName());
                    }
                }
                personQuery.save(person);
            }
        }
    }
}

@Component
class PositionEventListener implements ApplicationListener<PositionEvent> {
    @Autowired
    private PersonQuery personQuery;

    @Override
    public void onApplicationEvent(PositionEvent event) {
        PositionQueryModel target = event.getTarget();
        if (target != null) {
            PositionQueryModel source = (PositionQueryModel) event.getSource();
            if (StringUtils.equals(source.getId(), target.getId())) {
                if (!StringUtils.equals(source.getName(), target.getName())) {
                    List<PersonQueryModel> personList = personQuery.findAllByPositionId(source.getId());
                    personList.forEach(person -> {
                        person.setPositionName(target.getName());
                    });
                    personQuery.saveAll(personList);
                }
            }
        }
    }
}
