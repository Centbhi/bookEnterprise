package com.hizon.serviceImpl;
import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import com.hizon.service.GenericService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class GenericServiceImpl<ModelData,Model> implements GenericService<Model>{
    
    private final JpaRepository<ModelData, Integer> repo;
    private final ModelMapper mapper;
    private final Class<ModelData> modelDataClass;
    private final Class<Model> Book;

    @Override
    public Model create(Model model){
        ModelData entity = mapper.map(model, modelDataClass);
        try{
            Field idField = modelDataClass.getDeclaredField("id");
            idField.setAccessible(true);
            idField.set(entity, null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("Failed to set ID to null", e);
        }

        ModelData saved = repo.save(entity);
        return mapper.map(saved,Book);
    }

    @Override
    public Model read(Integer id){
        ModelData entity = repo.findById(id)
        .orElseThrow(() -> new RuntimeException(modelDataClass.getSimpleName() + "not found with id: " + id));
        return mapper.map(entity, Book);
    }

    @Override
    public List<Model> readAll(){
        return repo.findAll().stream()
            .map(entity -> mapper.map(entity, Book))
            .collect(Collectors.toList());
    }

    @Override
    public Model update(int id,Model model){

        ModelData entity = repo.findById(id).orElseThrow(()->
            new RuntimeException(modelDataClass.getSimpleName() + " not found with id: " + id));
        try {
            Field idField = modelDataClass.getDeclaredField("id");
            idField.setAccessible(true);
            idField.set(entity, id);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("Failed to set ID to null", e);
        }


        mapper.map(model,entity);
        ModelData saved = repo.save(entity);
        return mapper.map(saved,Book);
    }

    @Override
    public void delete(Integer id){
        if(!repo.existsById(id)){
            throw new RuntimeException("Model not found with id: " + id);
        }
        repo.deleteById(id);
    }
}
