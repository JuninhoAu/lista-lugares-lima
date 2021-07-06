package com.juni.limaguialugares.lista

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.juni.limaguialugares.Places

class ListViewModel: ViewModel() {

    private val _placeList=MutableLiveData<MutableList<Places>>()
     val placeList: LiveData<MutableList<Places>>
    get() = _placeList

    init {
        fetchPlaces()
    }

    private fun fetchPlaces() {

        val listPlaces= mutableListOf<Places>()

        listPlaces.add(Places(1, "Barranco", "Parque del amor","La belleza del parque se encuentra compuesta, por la estupenda vista que se consigue desde aquel, además de por ese aire romántico que se respira en el ambiente y que se ve ampliado por la presencia de una singular escultura: El Beso." ,
                "https://lh3.googleusercontent.com/pw/ACtC-3f0oCTWqcLqOb47XI0cxmjWDfjbiLke0maPSPdC4jY_4PKdJIBAyQXV__sYUDbrfRctynBCdAN5selEMQPwOnI_kyioqhpGaqTBTTJP6FFPFF37coJUzb0MP5aSZIhjiXxVLRznFIVw_DbsyJNe1jLS=w1250-h938-no"

        ))
        listPlaces.add(Places(2, "Miraflores", "Centro Comercial Larcomar", "-12.13170421681222, -77.03045689514325",

                "https://lh3.googleusercontent.com/pw/ACtC-3eAMq_LzjGRHsrqxf2DK_CGv5ly2KrXP5GH3Dd0RYlt4QjGWAbVjhQiKEx9eRHyysMc4apCZ3HOXce24f89RMmstGLk5p1YttAnB8OcZjVY9z_v1YKJt2YYJEf0TSndti2r8bqCjZ9WYIPDaxRfXyUJ=w1258-h943-no?authuser=0"
        ))

        listPlaces.add(Places(4, "Cercado de Lima", "Jiron de la Unión","-12.045671230888585, -77.03106980703227",

                "https://lh3.googleusercontent.com/pw/ACtC-3f3pupeYW4RBpWbVz0u9BF4JmhzoXhr_OATFyYbIVZMD7tSrZ1Fkboc5zQIAHp1plQSIZLXaKFWkPECNcIx0ZGz9xgBNLoE1auYGceeRT2nZkNU92wi9f5qBjxfhjKjut5U4bWAiqCUqrA2l7KJPkYp=w1437-h943-no?authuser=0"
        ))
        listPlaces.add(Places(5, "Rimac", "Iglesia de San Pedro", "-12.045228750868528, -77.02704148876724",

                "https://lh3.googleusercontent.com/pw/ACtC-3fuMNrZXnJ2Lh7-NpkVpE2y-fHshdWpT9yBB2OO0HrQKMyUxNGupjeXWeHpBtnH-M_DSL36GX_rxMF1mH4radisLWZiKKIMNCCxDKtHyossdMXUjrReVfASeus01rDRps_Er3nBu0pGvTeIvGx3Hzk6=w1258-h943-no?authuser=0"
        ))
        listPlaces.add(Places(6, "Barranco", "Parque Federico Villareal","-12.147955479581848, -77.02234608462015",

"https://lh3.googleusercontent.com/pw/ACtC-3dHaOaGSHvRS8BIhMIH_dChhrt_PB-u6Vx4hAB1W9njYQWbarXo1OP-O_n2ASXsn3QYiqr6aOkx34DzJRalBsNPJfl58rguizsICb63lzgq7K-_h2kEVZbwq362ddWcrUkyNAyayl6LdykHeDOsqXR_=w1038-h943-no"))
        listPlaces.add(Places(7, "Barranco", "Malecón Souza", "-12.143354905974437, -77.02481291791479",

"https://lh3.googleusercontent.com/pw/ACtC-3fSkf5DMfCpX9jOyehnil9j1TgTwiSXhnoTFaItGCiC8XfK3r0Nj0TdcIBaltQ9Ph0E_6KhOZk4q7loKbteT5VlQbKmDOyehpJuIIiHul6HhYLp5LnNqY1bib_wEsLoq8Cjx6a6P_t_8nfiThn45Akv=w1163-h943-no"        ))

        _placeList.value=listPlaces

    }
}