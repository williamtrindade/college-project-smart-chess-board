<!DOCTYPE html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Laravel</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <!-- Fonts -->
        <link href="https://fonts.googleapis.com/css2?family=Nunito:wght@400;600;700&display=swap" rel="stylesheet">
        <!-- Styles -->
        <style>
            .title {
                font-size:180%;
            }
        </style>

    </head>
    <body class="antialiased">
        <!-- Just an image -->
        <nav class="navbar navbar-light bg-light">
            <div class="container">
                <a class="navbar-brand" href="#">
                    <img src="https://cdn0.iconfinder.com/data/icons/chess-26/128/7-512.png" width="40" height="40" alt="">
                    Smart Chess
                </a>
            </div>
        </nav>
        <div class="container mt-2">
            <h1 class="title">Matches</h1>
            <table class="table responsive" aria-describedby="Match">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th id="date">Date</th>
                        <th id="name">Name</th>
                        <th id="winner">Winner</th>
                        <th id="moves">Moves</th>
                    </tr>
                </thead>
                <tbody>
                    @foreach ($chess_matches as $chess_match)
                        <tr>
                            <td>{{ $chess_match->id }}</td>
                            <td>{{ $chess_match->created_at }}</td>
                            <td>{{ $chess_match->name }}</td>
                            <td>{{ $chess_match->winner }}</td>
                            <td>
                                <button
                                    type="button"
                                    class="btn btn-sm btn-primary"
                                    data-toggle="modal"
                                    data-target="#exampleModalLong{{$chess_match->id}}"
                                >
                                    See PGN
                                </button>
                                <!-- Modal -->
                                <div class="modal fade" id="exampleModalLong{{$chess_match->id}}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
                                    <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="exampleModalLongTitle">{{ $chess_match->name }}</h5>
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body">
                                                <h6>Moves</h6>
                                                <hr>
                                                <table class="table" aria-describedby="Match">
                                                    <thead>
                                                    <tr>
                                                        <th scope="col">#</th>
                                                        <th id="white">White</th>
                                                        <th id="black">Black</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                        @foreach ($chess_match->moves as $move)
                                                            <tr>
                                                                <td>{{ $move->id }}</td>
                                                                <td>{{ $move->white }}</td>
                                                                <td>{{ $move->black }}</td>
                                                            </tr>
                                                        @endforeach
                                                    </tbody>
                                                </table>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </td>
                        </tr>
                    @endforeach
                </tbody>
            </table>
        </div>
    </body>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</html>
