package lingvo.movie.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yaroslav on 01.03.15.
 */
@Entity
@Table(name = "MEDIA_ITEM")
@Data
@ToString(of = {"name", "displayPath"}) @EqualsAndHashCode(of = {"name", "displayPath"})
public class MediaItem {
    @Id @GeneratedValue
    Long id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String displayPath;

    @ElementCollection
    @JoinTable(name="MEDIA_ITEM_META_INFO")
    @MapKeyColumn(name = "attr_name")
    @Column(name="attr_value")
    Map<String, String> metaInfo = new HashMap<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dictionary_id", nullable = false)
    @JsonIgnore
    Dictionary dictionary;
}
