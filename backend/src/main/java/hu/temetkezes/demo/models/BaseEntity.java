package hu.temetkezes.demo.models;
import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import hu.temetkezes.demo.domain.RequestContext;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import org.springframework.util.AlternativeJdkIdGenerator;
import hu.temetkezes.demo.exception.ApiException;

import static hu.temetkezes.demo.DemoApplication.seed;
import static java.time.LocalDateTime.now;

@Setter
@Getter
@MappedSuperclass
@JsonIgnoreProperties(value = {"createdAt","updatedAt"},allowGetters = true)
public abstract class BaseEntity implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String referenceId = new AlternativeJdkIdGenerator().generateId().toString();
    private Long createdBy;
    private Long updatedBy;
    @NotNull
    @Column(name="created_at",nullable = false,updatable = false)
    private LocalDateTime createdAt;
    @NotNull
    @Column(name="update_at",nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    public void beforePersist(){
        if (seed) {
            var userId = 1L;
            setCreatedAt(now());
            setCreatedBy(userId);
            setUpdatedBy(userId);
            setUpdatedAt(now());
        } else {
            var userId = RequestContext.getUserId();
            if(userId == null) throw new ApiException("Cannot persist entity  without user ID in Request Context for this thread");
            setCreatedAt(now());
            setCreatedBy(userId);
            setUpdatedBy(userId);
            setUpdatedAt(now());
        }
    }
    @PreUpdate
    public void beforeUpdate(){
        var userId = RequestContext.getUserId();
        if(userId == null) throw new ApiException("Cannot update entity  without user ID in Request Context for this thread");
        setUpdatedBy(userId);
        setUpdatedAt(now());
    }
}