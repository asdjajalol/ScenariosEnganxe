package me.imzomi.uhcscenarios.manager;

import me.imzomi.uhcscenarios.scenarios.*;

import java.util.HashSet;
import java.util.List;

public class ScenarioManager {
    private HashSet<Scenario> scenarios = new HashSet<>();
    private static ScenarioManager instance = new ScenarioManager();

    public void setup() {
        scenarios.add(new AbsorptionLess());
        scenarios.add(new AnvilLess());
        scenarios.add(new AntiBurn());
        scenarios.add(new BareBones());
        scenarios.add(new Bats());
        scenarios.add(new BattleParanoia());
        scenarios.add(new BetaZombies());
        scenarios.add(new BiomeBoost());
        scenarios.add(new BlastMining());
        scenarios.add(new BleedingSweets());
        scenarios.add(new Blocked());
        scenarios.add(new BloodAnvil());
        scenarios.add(new BloodDiamonds());
        scenarios.add(new BloodEnchant());
        scenarios.add(new BloodGold());
        scenarios.add(new BloodLapis());
        scenarios.add(new Bowless());
        scenarios.add(new CleanSlate());
        scenarios.add(new CobwebLess());
        scenarios.add(new Coldweapons());
        scenarios.add(new Cripple());
        scenarios.add(new CutClean());
        scenarios.add(new DamageParanoia());
        scenarios.add(new DiamondLess());
        scenarios.add(new DoubleOres());
        scenarios.add(new EmeraldFever());
        scenarios.add(new EnchantedDeath());
        scenarios.add(new FastGetaway());
        scenarios.add(new FenceHead());
        scenarios.add(new Fireless());
        scenarios.add(new GappleRoulette());
        scenarios.add(new GoldenRetriever());
        scenarios.add(new GoldLess());
        scenarios.add(new HasteyBabies());
        scenarios.add(new HasteyBoys());
        scenarios.add(new HasteyBoysPlus());
        scenarios.add(new HeavyPockets());
        scenarios.add(new Krenzinator());
        scenarios.add(new LuckyLeaves());
        scenarios.add(new NoClean());
        scenarios.add(new NoFall());
        scenarios.add(new PermaKill());
        scenarios.add(new RewardingBlocks());
        scenarios.add(new ShieldLess());
        scenarios.add(new Switcheroo());
        scenarios.add(new SwordLess());
        scenarios.add(new Timber());
        scenarios.add(new TimeBomb());
        scenarios.add(new TripleOres());
        scenarios.add(new UltraParanoia());
        scenarios.add(new VengefulSpirits());
    }


    public static ScenarioManager getInstance() {
        return instance;
    }

    public Scenario getScenario(String s) {
        for (Scenario scen : scenarios) {
            if (s.equalsIgnoreCase(scen.getName())) return scen;
        }
        return null;
    }

    public List<Scenario> getScenarios() {
        return scenarios.stream().toList();
    }
    public List<Scenario> getEnabledScenarios() {
        return scenarios.stream().filter(Scenario::isEnabled).toList();
    }
}
