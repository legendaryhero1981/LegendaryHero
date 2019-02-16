package legend.game.run.entity;

import static legend.util.ValueUtil.nonEmpty;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import legend.game.run.intf.IMain;

@XmlRootElement(name = "Games")
@XmlType(propOrder = {"comment","games"})
public class Games implements IMain{
    @XmlTransient
    private ConcurrentMap<String,Game> gameMap = new ConcurrentHashMap<>();
    @XmlElement
    private String comment = GAMES_COMMENT;
    @XmlElementRef
    private List<Game> games = new CopyOnWriteArrayList<>();

    public ConcurrentMap<String,Game> getGameMap(){
        if(gameMap.isEmpty()) refreshGameMap();
        return gameMap;
    }

    public ConcurrentMap<String,Game> refreshGameMap(){
        if(nonEmpty(games)) games.parallelStream().forEach(game->gameMap.put(game.getId(),game));
        return gameMap;
    }

    public List<Game> getGames(){
        return games;
    }
}
