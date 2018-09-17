package com.usage.dagger.daggerusage.data.mappers;

import java.util.ArrayList;
import java.util.List;

public abstract class ModelEntityMapper<Entity, Model> {

    public List<Model> entityToModel(List<Entity> entities) {
        List<Model> models = new ArrayList<>();
        for (Entity entity : entities) {
            models.add(entityToModel(entity));
        }
        return models;
    }

    public abstract Model entityToModel(Entity entity);

    public List<Entity> modelToEntity(List<Model> models) {
        List<Entity> entities = new ArrayList<>();
        for (Model model : models) {
            entities.add(modelToEntity(model));
        }
        return entities;
    }

    public abstract Entity modelToEntity(Model model);
}
