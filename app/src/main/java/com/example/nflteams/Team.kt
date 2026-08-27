package com.example.nflteams

/**
 * Simple data model for an NFL team.
 *
 * [color] is the team's official primary color, used to render a generated
 * badge thumbnail (colored circle + abbreviation) when no real logo image
 * is supplied.
 *
 * [logoRes] is an OPTIONAL drawable resource name (no extension, e.g.
 * "logo_buf") for a real logo image dropped into res/drawable. If set and
 * the resource exists, the adapter shows that image instead of the
 * generated badge.
 */
data class Team(
    val name: String,
    val abbr: String,
    val conference: String, // "AFC" or "NFC"
    val color: String,       // hex color, e.g. "#013369"
    val logoRes: String? = null
)

object TeamRepository {

    val teams: List<Team> = listOf(
        // AFC East
        Team("Buffalo Bills", "BUF", "AFC", "#00338D", logoRes = "logo_buf"),
        Team("Miami Dolphins", "MIA", "AFC", "#008E97"),
        Team("New England Patriots", "NE", "AFC", "#002244"),
        Team("New York Jets", "NYJ", "AFC", "#125740"),

        // AFC North
        Team("Baltimore Ravens", "BAL", "AFC", "#241773"),
        Team("Cincinnati Bengals", "CIN", "AFC", "#FB4F14"),
        Team("Cleveland Browns", "CLE", "AFC", "#311D00"),
        Team("Pittsburgh Steelers", "PIT", "AFC", "#FFB612"),

        // AFC South
        Team("Houston Texans", "HOU", "AFC", "#03202F"),
        Team("Indianapolis Colts", "IND", "AFC", "#002C5F"),
        Team("Jacksonville Jaguars", "JAX", "AFC", "#101820"),
        Team("Tennessee Titans", "TEN", "AFC", "#0C2340"),

        // AFC West
        Team("Denver Broncos", "DEN", "AFC", "#FB4F14"),
        Team("Kansas City Chiefs", "KC", "AFC", "#E31837"),
        Team("Las Vegas Raiders", "LV", "AFC", "#000000"),
        Team("Los Angeles Chargers", "LAC", "AFC", "#0080C6"),

        // NFC East
        Team("Dallas Cowboys", "DAL", "NFC", "#003594"),
        Team("New York Giants", "NYG", "NFC", "#0B2265"),
        Team("Philadelphia Eagles", "PHI", "NFC", "#004C54"),
        Team("Washington Commanders", "WAS", "NFC", "#5A1414"),

        // NFC North
        Team("Chicago Bears", "CHI", "NFC", "#0B162A"),
        Team("Detroit Lions", "DET", "NFC", "#0076B6"),
        Team("Green Bay Packers", "GB", "NFC", "#203731"),
        Team("Minnesota Vikings", "MIN", "NFC", "#4F2683"),

        // NFC South
        Team("Atlanta Falcons", "ATL", "NFC", "#A71930"),
        Team("Carolina Panthers", "CAR", "NFC", "#0085CA"),
        Team("New Orleans Saints", "NO", "NFC", "#D3BC8D"),
        Team("Tampa Bay Buccaneers", "TB", "NFC", "#D50A0A"),

        // NFC West
        Team("Arizona Cardinals", "ARI", "NFC", "#97233F"),
        Team("Los Angeles Rams", "LAR", "NFC", "#003594"),
        Team("San Francisco 49ers", "SF", "NFC", "#AA0000"),
        Team("Seattle Seahawks", "SEA", "NFC", "#002244")
    )
}