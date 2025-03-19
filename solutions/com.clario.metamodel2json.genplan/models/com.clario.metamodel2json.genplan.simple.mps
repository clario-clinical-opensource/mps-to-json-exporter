<?xml version="1.0" encoding="UTF-8"?>
<model ref="r:c4922a30-da8a-4363-a04b-275a02dd15dc(com.clario.metamodel2json.genplan.simple)">
  <persistence version="9" />
  <languages>
    <use id="7866978e-a0f0-4cc7-81bc-4d213d9375e1" name="jetbrains.mps.lang.smodel" version="19" />
    <use id="7ab1a6fa-0a11-4b95-9e48-75f363d6cb00" name="jetbrains.mps.lang.generator.plan" version="2" />
  </languages>
  <imports />
  <registry>
    <language id="7ab1a6fa-0a11-4b95-9e48-75f363d6cb00" name="jetbrains.mps.lang.generator.plan">
      <concept id="1152961914448136207" name="jetbrains.mps.lang.generator.plan.structure.LanguageEntry" flags="ng" index="2Qf6Nf">
        <child id="1152961914448136208" name="language" index="2Qf6Ng" />
      </concept>
      <concept id="1820634577908471803" name="jetbrains.mps.lang.generator.plan.structure.Plan" flags="ng" index="2VgMpV">
        <child id="1820634577908471815" name="steps" index="2VgMA7" />
      </concept>
      <concept id="1820634577908471810" name="jetbrains.mps.lang.generator.plan.structure.Transform" flags="ng" index="2VgMA2">
        <child id="1152961914448142326" name="entries" index="2Qf7GQ" />
      </concept>
    </language>
    <language id="7866978e-a0f0-4cc7-81bc-4d213d9375e1" name="jetbrains.mps.lang.smodel">
      <concept id="3542851458883438784" name="jetbrains.mps.lang.smodel.structure.LanguageId" flags="nn" index="2V$Bhx">
        <property id="3542851458883439831" name="namespace" index="2V$B1Q" />
        <property id="3542851458883439832" name="languageId" index="2V$B1T" />
      </concept>
    </language>
    <language id="ceab5195-25ea-4f22-9b92-103b95ca8c0c" name="jetbrains.mps.lang.core">
      <concept id="1169194658468" name="jetbrains.mps.lang.core.structure.INamedConcept" flags="ngI" index="TrEIO">
        <property id="1169194664001" name="name" index="TrG5h" />
      </concept>
    </language>
  </registry>
  <node concept="2VgMpV" id="2qhlwWB3thX">
    <property role="TrG5h" value="Model2JsonPlan" />
    <node concept="2VgMA2" id="2qhlwWB3thZ" role="2VgMA7">
      <node concept="2Qf6Nf" id="3gIe8ZWPU$1" role="2Qf7GQ">
        <node concept="2V$Bhx" id="6_c2lbyWMGT" role="2Qf6Ng">
          <property role="2V$B1T" value="c72bb5ed-7d2b-4e68-8d06-5f02045d0bcc" />
          <property role="2V$B1Q" value="com.clario.model2json" />
        </node>
      </node>
    </node>
  </node>
  <node concept="2VgMpV" id="2qhlwWB1l7J">
    <property role="TrG5h" value="Metamodel2Java" />
    <node concept="2VgMA2" id="2qhlwWB1l8a" role="2VgMA7">
      <node concept="2Qf6Nf" id="3gIe8ZWPU$2" role="2Qf7GQ">
        <node concept="2V$Bhx" id="6_c2lbyWMGU" role="2Qf6Ng">
          <property role="2V$B1T" value="f81274ef-51e9-4fbc-9bcc-505d21a35248" />
          <property role="2V$B1Q" value="com.clario.metamodel2java" />
        </node>
      </node>
    </node>
    <node concept="2VgMA2" id="2qhlwWB22_t" role="2VgMA7">
      <node concept="2Qf6Nf" id="3gIe8ZWPU$3" role="2Qf7GQ">
        <node concept="2V$Bhx" id="4$78109EYHZ" role="2Qf6Ng">
          <property role="2V$B1T" value="fd392034-7849-419d-9071-12563d152375" />
          <property role="2V$B1Q" value="jetbrains.mps.baseLanguage.closures" />
        </node>
      </node>
      <node concept="2Qf6Nf" id="3gIe8ZWPU$4" role="2Qf7GQ">
        <node concept="2V$Bhx" id="2qhlwWB22_$" role="2Qf6Ng">
          <property role="2V$B1T" value="f3061a53-9226-4cc5-a443-f952ceaf5816" />
          <property role="2V$B1Q" value="jetbrains.mps.baseLanguage" />
        </node>
      </node>
    </node>
  </node>
  <node concept="2VgMpV" id="3DosGw5d9k2">
    <property role="TrG5h" value="Metamodel2JsonSchema" />
    <node concept="2VgMA2" id="3DosGw5d9k4" role="2VgMA7">
      <node concept="2Qf6Nf" id="3gIe8ZWPU$5" role="2Qf7GQ">
        <node concept="2V$Bhx" id="6_c2lbyWMGV" role="2Qf6Ng">
          <property role="2V$B1T" value="37ca9e63-a2a3-4038-b64b-816e865c36b1" />
          <property role="2V$B1Q" value="com.clario.metamodel2jsonschema" />
        </node>
      </node>
    </node>
  </node>
</model>

