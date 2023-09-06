package com.example.myapplication

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
//import java.lang.ClassCastException
import kotlin.ClassCastException

class ListFragment : Fragment() {

    interface PokemonSelectListener {
        fun onPokemonSelected(pokemon: Pokemon)
    }
    private lateinit var pokemonSelectListener: PokemonSelectListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        pokemonSelectListener = try {
            context as PokemonSelectListener
        } catch (e: ClassCastException) {
            throw ClassCastException("$context must implement PokemonSelectListener")
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        val recycler = view.findViewById<RecyclerView>(R.id.pokemon_recycler)
        recycler.layoutManager = LinearLayoutManager(requireActivity())
        val adapter = PokemonAdapter()
        recycler.adapter = adapter

        adapter.onItemClickListener = {
            pokemonSelectListener.onPokemonSelected(it)
        }

        val pokemonList = mutableListOf(
            Pokemon( 1, BULBASAUR, 45, 49, 49, 45, Pokemon.PokemonType.GRASS,
                "https://images.wikidexcdn.net/mwuploads/wikidex/7/74/latest/20230210210358/EP1230_Bulbasaur_de_Ash.png"),
            Pokemon( 2, IVYSAUR, 60, 62, 63, 60, Pokemon.PokemonType.GRASS,
                "https://static.wikia.nocookie.net/espokemon/images/b/bf/EH15_Ivysaur_de_Crystal.png/revision/latest/scale-to-width-down/250?cb=20110814194745"),
            Pokemon( 3, VENUASAUR, 80, 82, 83, 80, Pokemon.PokemonType.GRASS,
                "https://i.pinimg.com/originals/65/f9/14/65f914100cf91bbe249282b79231e41c.png"),
            Pokemon( 4, CHARMANDER, 39, 52, 43, 65, Pokemon.PokemonType.FIRE,
                "https://oyster.ignimgs.com/mediawiki/apis.ign.com/pokemon-blue-version/d/d4/Charmander.gif"),
            Pokemon( 5, CHARMELEON, 58, 64, 58, 80, Pokemon.PokemonType.FIRE,
                "https://static.wikia.nocookie.net/pokemon-super-fanon/images/4/4b/Charmeleon.jpg/revision/latest?cb=20151201213318&path-prefix=es"),
            Pokemon( 6, CHARIZZARD, 78, 84, 78, 100, Pokemon.PokemonType.FIRE,
                "https://assets.pokemon.com/assets/cms2/img/pokedex/full/006.png"),
            Pokemon( 7, SQUITER, 44, 48, 65, 43, Pokemon.PokemonType.WATER,
                "https://oyster.ignimgs.com/mediawiki/apis.ign.com/pokemon-blue-version/a/a3/Squirtle.gif"),
            Pokemon( 8, WARTORTLE, 59, 63, 80, 58, Pokemon.PokemonType.WATER,
                "https://static.wikia.nocookie.net/pokemon-super-fanon/images/d/d7/Wartortle.png/revision/latest?cb=20151126220205&path-prefix=es"),
            Pokemon( 9, BLASTOISE, 79, 83, 100, 78, Pokemon.PokemonType.WATER,
                "https://i.pinimg.com/originals/60/73/4d/60734d8b55944058bbeb969e8665a05d.png"),
            Pokemon( 10, PICHU, 40, 50, 55, 35, Pokemon.PokemonType.ELECTRIC,
                "https://static.wikia.nocookie.net/universecw/images/9/9d/Pichu.png/revision/latest?cb=20210228101557&path-prefix=es"),
            Pokemon( 11, PIKACHU, 35, 55, 40, 90, Pokemon.PokemonType.ELECTRIC,
                "https://w7.pngwing.com/pngs/585/436/png-transparent-pokemon-pikachu-illustration-icon-pikachu-background-mammal-food-vertebrate-thumbnail.png"),
            Pokemon( 12, RAICHU, 60, 90, 55, 110, Pokemon.PokemonType.ELECTRIC,
                "https://w7.pngwing.com/pngs/960/272/png-transparent-pikachu-pokemon-adventures-pokemon-go-raichu-pikachu-honey-bee-mammal-cat-like-mammal.png"),
            Pokemon( 13, POLIWRATH, 57, 67, 70, 90, Pokemon.PokemonType.FIGHTER,
                "https://img.wattpad.com/062d970b70e3021c0eb053dd8bfc5a1434e9e6cf/68747470733a2f2f73332e616d617a6f6e6177732e636f6d2f776174747061642d6d656469612d736572766963652f53746f7279496d6167652f544b3244304d57305530594853673d3d2d3638353235383638372e313537633664643363643762353663363639313034333036313337322e6a7067?s=fit&w=720&h=720"),
            Pokemon( 14, MACHAMP, 54, 88, 98, 87, Pokemon.PokemonType.FIGHTER,
                "https://i.pinimg.com/originals/42/f7/1a/42f71a4e8fc409cad06c241df2fb058b.png"),
            Pokemon( 15, HITMONLEE, 45, 86, 77, 99, Pokemon.PokemonType.FIGHTER,
                "https://pm1.aminoapps.com/6202/14c76f537faacc48d3c6ed50a8652be773e0b5eb_00.jpg"),
            )
        adapter.submitList(pokemonList)

        return view
    }

    companion object {
        const val BULBASAUR = "Bulbasaur"
        const val IVYSAUR = "Ivysaur"
        const val VENUASAUR = "Venuasaur"
        const val CHARMANDER = "Charmander"
        const val CHARMELEON = "Charmeleon"
        const val CHARIZZARD = "Charizzard"
        const val SQUITER = "Squitler"
        const val WARTORTLE = "Wartortle"
        const val BLASTOISE = "Blastoise"
        const val PICHU = "Pichu"
        const val PIKACHU = "Pikachu"
        const val RAICHU = "Raichu"
        const val POLIWRATH = "Poliwrath"
        const val MACHAMP = "Machamp"
        const val HITMONLEE = "Hitmonlee"
    }
}