package com.belia.speedotransfer.ui.auth.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.belia.speedotransfer.R
import com.belia.speedotransfer.ui.theme.GrayG10
import com.belia.speedotransfer.ui.theme.GrayG100
import com.belia.speedotransfer.ui.theme.GrayG70
import com.belia.speedotransfer.ui.theme.GrayG700
import com.belia.speedotransfer.ui.theme.RedP300
import com.belia.speedotransfer.ui.theme.RedP50
import com.belia.speedotransfer.ui.theme.bodyMedium16
import com.belia.speedotransfer.ui.theme.bodyRegular16

object Countries {
    val name = listOf(
        "Afghanistan",
        "Albania",
        "Algeria",
        "Andorra",
        "Angola",
        "Antigua and Barbuda",
        "Argentina",
        "Armenia",
        "Australia",
        "Austria",
        "Azerbaijan",
        "Bahamas",
        "Bahrain",
        "Bangladesh",
        "Barbados",
        "Belarus",
        "Belgium",
        "Belize",
        "Benin",
        "Bhutan",
        "Bolivia",
        "Bosnia and Herzegovina",
        "Botswana",
        "Brazil",
        "Brunei",
        "Bulgaria",
        "Burkina Faso",
        "Burundi",
        "Cambodia",
        "Cameroon",
        "Canada",
        "Cape Verde",
        "Central African Republic",
        "Chad",
        "Chile",
        "China",
        "Colombia",
        "Comoros",
        "Congo",
        "Costa Rica",
        "Croatia",
        "Cuba",
        "Cyprus",
        "Czech Republic",
        "Denmark",
        "Djibouti",
        "Dominica",
        "Dominican Republic",
        "Ecuador",
        "Egypt",
        "El Salvador",
        "Equatorial Guinea",
        "Eritrea",
        "Estonia",
        "Ethiopia",
        "Fiji",
        "Finland",
        "France",
        "Gabon",
        "Gambia",
        "Georgia",
        "Germany",
        "Ghana",
        "Greece",
        "Grenada",
        "Guatemala",
        "Guinea",
        "Guinea-Bissau",
        "Guyana",
        "Haiti",
        "Honduras",
        "Hungary",
        "Iceland",
        "India",
        "Indonesia",
        "Iran",
        "Iraq",
        "Ireland",
        "Israel",
        "Italy",
        "Jamaica",
        "Japan",
        "Jordan",
        "Kazakhstan",
        "Kenya",
        "Kiribati",
        "North Korea",
        "South Korea",
        "Kuwait",
        "Kyrgyzstan",
        "Laos",
        "Latvia",
        "Lebanon",
        "Lesotho",
        "Liberia",
        "Libya",
        "Liechtenstein",
        "Lithuania",
        "Luxembourg",
        "Madagascar",
        "Malawi",
        "Malaysia",
        "Maldives",
        "Mali",
        "Malta",
        "Marshall Islands",
        "Mauritania",
        "Mauritius",
        "Mexico",
        "Micronesia",
        "Moldova",
        "Monaco",
        "Mongolia",
        "Montenegro",
        "Morocco",
        "Mozambique",
        "Myanmar",
        "Namibia",
        "Nauru",
        "Nepal",
        "Netherlands",
        "New Zealand",
        "Nicaragua",
        "Niger",
        "Nigeria",
        "North Macedonia",
        "Norway",
        "Oman",
        "Pakistan",
        "Palau",
        "Panama",
        "Papua New Guinea",
        "Paraguay",
        "Peru",
        "Philippines",
        "Poland",
        "Portugal",
        "Qatar",
        "Romania",
        "Russia",
        "Rwanda",
        "Saint Kitts and Nevis",
        "Saint Lucia",
        "Saint Vincent and the Grenadines",
        "Samoa",
        "San Marino",
        "São Tomé and Príncipe",
        "Saudi Arabia",
        "Senegal",
        "Serbia",
        "Seychelles",
        "Sierra Leone",
        "Singapore",
        "Slovakia",
        "Slovenia",
        "Solomon Islands",
        "Somalia",
        "South Africa",
        "South Sudan",
        "Spain",
        "Sri Lanka",
        "Sudan",
        "Suriname",
        "Eswatini",
        "Sweden",
        "Switzerland",
        "Syria",
        "Tajikistan",
        "Tanzania",
        "Thailand",
        "Timor-Leste",
        "Togo",
        "Tonga",
        "Trinidad and Tobago",
        "Tunisia",
        "Turkey",
        "Turkmenistan",
        "Tuvalu",
        "Uganda",
        "Ukraine",
        "United Arab Emirates",
        "United Kingdom",
        "United States",
        "Uruguay",
        "Uzbekistan",
        "Vanuatu",
        "Vatican City",
        "Venezuela",
        "Vietnam",
        "Yemen",
        "Zambia",
        "Zimbabwe"
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountryPicker(modifier: Modifier = Modifier, onClick: (String) -> Unit) {
    var countryName by remember { mutableStateOf("") }
    var selectedCountry by remember { mutableStateOf<Int?>(null) }
    var isBottomSheetVisible by remember { mutableStateOf(false) }
    var state = rememberModalBottomSheetState()

    Text(
        text = "Country",
        style = bodyRegular16,
        color = GrayG700,
        modifier = modifier.padding(vertical = 8.dp)
    )

    OutlinedTextField(
        value = countryName,
        onValueChange = { countryName = it },
        enabled = false,
        readOnly = true,
        colors = OutlinedTextFieldDefaults.colors(
            disabledTrailingIconColor = GrayG100,
            disabledContainerColor = GrayG10,
            disabledBorderColor = GrayG70,
            disabledPlaceholderColor = GrayG70,
        ),
        placeholder = { Text(text = "Select your country", color = GrayG70) },
        trailingIcon = {
            IconButton(onClick = { isBottomSheetVisible = true }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_dropdown),
                    contentDescription = "select a country ",
                    modifier = modifier.size(24.dp)
                )
            }
        },
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
            .clickable {
                isBottomSheetVisible = true
            }
    )

    if (isBottomSheetVisible) {
        ModalBottomSheet(
            sheetState = state,
            content = {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    items(Countries.name) { country ->
                        CountryItem(
                            country = country,
                            isSelected = selectedCountry == Countries.name.indexOf(country),
                            imageUrl = "",
                            onSelect = {
                                selectedCountry = Countries.name.indexOf(country)
                                isBottomSheetVisible = false
                            }
                        ) {
                            onClick(it)
                            countryName = it
                        }
                    }
                }
            },
            onDismissRequest = { isBottomSheetVisible = false }
        )
    }
}


@Composable
fun CountryItem(
    country: String,
    isSelected: Boolean,
    imageUrl: String,
    onSelect: () -> Unit,
    onCardClick: (String) -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(if (isSelected) RedP50 else Color.Transparent)
            .clickable {
                onCardClick(country)
                onSelect()
            },
    ) {
        Spacer(modifier = Modifier.padding(start = 8.dp))
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                //.data("https://example.com/image.jpg")
                .build(),
            contentDescription = "Country Image",
            placeholder = painterResource(R.drawable.calender),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .size(24.dp)
        )
        Text(
            text = country,
            style = bodyMedium16,
            color = Color(0xFF706E6C),
            modifier = Modifier.padding(start = 8.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        if (isSelected) {
            Icon(
                painter = painterResource(id = R.drawable.ic_check),
                contentDescription = "Selected Country",
                tint = RedP300,
                modifier = Modifier.padding(end = 16.dp)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = false)
@Composable
private fun prevv() {
    CountryPicker {

    }
}